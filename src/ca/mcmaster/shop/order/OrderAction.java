package ca.mcmaster.shop.order;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.regexp.internal.REDebugCompiler;

import ca.mcmaster.shop.cart.Cart;
import ca.mcmaster.shop.cart.CartItem;
import ca.mcmaster.shop.user.User;

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
}
