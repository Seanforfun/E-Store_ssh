package ca.mcmaster.shop.order;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ca.mcmaster.shop.cart.Cart;
import ca.mcmaster.shop.cart.CartItem;
import ca.mcmaster.shop.user.User;

/**
 * @author Seanforfun
 * @version 2018年1月5日 上午12:45:52
 */
@SuppressWarnings("serial")
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	@Resource(name="orderService")
	private OrderService orderService;
	private String pd_FrpId;
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
				order.getOrderItem_set().add(orderItem);
			}
		}else {
			this.addActionError("No cart found, please go shopping first!");
		}
		orderService.saveOrder(order);
		return "SaveOrderSuccess";
	}
}
