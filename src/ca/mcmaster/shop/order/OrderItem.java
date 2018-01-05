package ca.mcmaster.shop.order;

/**
 * @author Seanforfun
 * @version 2018年1月5日 上午1:03:17
 */
public class OrderItem {
	private Integer orderItem_id;
	private Integer OrderItem_count;
	private Double OrderItem_subtotal;
	private Order OrderItem_belonging;
	public Integer getOrderItem_id() {
		return orderItem_id;
	}
	public void setOrderItem_id(Integer orderItem_id) {
		this.orderItem_id = orderItem_id;
	}
	public Integer getOrderItem_count() {
		return OrderItem_count;
	}
	public void setOrderItem_count(Integer orderItem_count) {
		OrderItem_count = orderItem_count;
	}
	public Double getOrderItem_subtotal() {
		return OrderItem_subtotal;
	}
	public void setOrderItem_subtotal(Double orderItem_subtotal) {
		OrderItem_subtotal = orderItem_subtotal;
	}
	public Order getOrderItem_belonging() {
		return OrderItem_belonging;
	}
	public void setOrderItem_belonging(Order orderItem_belonging) {
		OrderItem_belonging = orderItem_belonging;
	}
}
