package ca.mcmaster.shop.order;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ca.mcmaster.shop.cart.Cart;
import ca.mcmaster.shop.cart.CartItem;
import ca.mcmaster.shop.user.User;
import ca.mcmaster.shop.utils.PageInfoBean;
import ca.mcmaster.shop.utils.PaymentUtil;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 5, 2018 2:43:24 PM
 */
@SuppressWarnings("serial")
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	@Resource(name="orderService")
	private OrderService orderService;
	private String pd_FrpId;
	private Integer delete_orderItem_id;
	private Order order = new Order();
	private String p2_Order;
	private String p3_Amt;
	private Integer user_id;
	private Integer page;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getP2_Order() {
		return p2_Order;
	}

	public void setP2_Order(String p2_Order) {
		this.p2_Order = p2_Order;
	}

	public String getP3_Amt() {
		return p3_Amt;
	}

	public void setP3_Amt(String p3_Amt) {
		this.p3_Amt = p3_Amt;
	}

	@Override
	public Order getModel() {
		return order;
	}
	
	public String getPd_FrpId() {
		return pd_FrpId;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	public Integer getDelete_orderItem_id() {
		return delete_orderItem_id;
	}

	public void setDelete_orderItem_id(Integer delete_orderItem_id) {
		this.delete_orderItem_id = delete_orderItem_id;
	}

	public String saveOrder(){
		order.setOrder_status(0);
		order.setOrder_time(new Date());
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.containsKey("existUser")){
			User existUser = (User) session.get("existUser");
			order.setOrder_order_belonging(existUser);
		}else{
			this.addActionError("Please login first!");
		}
		if(session.containsKey("cart")){
			Cart cart = (Cart) session.get("cart");
			order.setOrder_total_price(cart.getTotal());
			Collection<CartItem> cartItems = cart.getMap().values();
			for(CartItem item : cartItems){
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderItem_belonging(order);
				orderItem.setOrderItem_count(item.getCount());
				orderItem.setOrderItem_subtotal(item.getSubtotal());
				orderItem.setOrderItem_product(item.getProduct());
				order.getOrderItem_set().add(orderItem);
			}
			cart.clearCart();
		}else {
			this.addActionError("No cart found, please go shopping first!");
		}
		orderService.saveOrder(order);
		return "SaveOrderSuccess";
	}
	
	public String removeOrderItem(){
		orderService.removeOrderItembyId(delete_orderItem_id);
		order = orderService.findOrderByOrder_id(order.getOrder_id());
		if(order.getOrderItem_set().size() == 0){
			orderService.removeOrderByOrder_id(order.getOrder_id());
			return "removeOrderItemEmptyOrder";
		}
		return "removeOrderItemSuccess";
	}
	
	public String payOrder() throws IOException{
		Order existOrder = orderService.findOrderByOrder_id(order.getOrder_id());
		existOrder.setOrder_address(order.getOrder_address());
		existOrder.setOrder_phone(order.getOrder_phone());
		existOrder.setOrder_receiver(order.getOrder_receiver());
		if(null != existOrder){
			orderService.updateOrder(existOrder);
		}
		//Set payment utils
		String  p0_Cmd = "Buy";
		String  p1_MerId = ResourceBundle.getBundle("payment").getString("p1_MerId");
		String  p2_Order = order.getOrder_id().toString();
		String  p3_Amt = existOrder.getOrder_total_price().toString();
		String  p4_Cur = "CNY";
		String  p5_Pid = "";
		String  p6_Pcat = "";
		String  p7_Pdesc = "";
		String  p8_Url = "http://localhost:80/E-store/order_callback.action";
		String  p9_SAF = "";
		String  pa_MP = "";
		String  pr_NeedResponse = "1";
		String keyValue = ResourceBundle.getBundle("payment").getString("keyValue");
		String[] requestArgs = new String[]{p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pr_NeedResponse};
		String  hmac = PaymentUtil.getHmac(requestArgs, keyValue);
		StringBuilder stringBuilder = new StringBuilder(ResourceBundle.getBundle("payment").getString("sendURL") + "?");
		stringBuilder.append("p0_Cmd=" + p0_Cmd);
		stringBuilder.append("&p1_MerId=" + p1_MerId);
		stringBuilder.append("&p2_Order=" + p2_Order);
		stringBuilder.append("&p3_Amt=" + p3_Amt);
		stringBuilder.append("&p1_MerId=" + p1_MerId);
		stringBuilder.append("&p4_Cur=" + p4_Cur);
		stringBuilder.append("&p5_Pid=" + p5_Pid);
		stringBuilder.append("&p6_Pcat=" + p6_Pcat);
		stringBuilder.append("&p7_Pdesc=" + p7_Pdesc);
		stringBuilder.append("&p8_Url=" + p8_Url);
		stringBuilder.append("&p9_SAF=" + p9_SAF);
		stringBuilder.append("&pa_MP=" + pa_MP);
		stringBuilder.append("&pr_NeedResponse=" + pr_NeedResponse);
		stringBuilder.append("&hmac=" + hmac);
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println(stringBuilder.toString());
		response.sendRedirect(stringBuilder.toString());
		return null;
	}
	
	public String callback(){
		orderService.updateAfterPay(p2_Order);
		return "callbackSuccess";
	}
	
	public String findOrderById(){
		Set<Order> orders = orderService.findOrderByUserId(user_id);
		if(orders != null){
			ActionContext.getContext().put("currrentUserOrders", orders);
		}
		return "findOrderByIdSuccess";
	}
	
	public String adminFindAll(){
		PageInfoBean<Order> pageBean = orderService.findAll(order.getOrder_status(), page);
		if(null != pageBean){
			ActionContext.getContext().put("pageBean", pageBean);
		}
		ActionContext.getContext().put("status", order.getOrder_status().toString());
		if(pageBean.getList().size() == 0 ){
			this.addActionMessage("No order found!");
		}
		return "adminFindAllSuccess";
	}
}
