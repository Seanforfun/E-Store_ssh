package ca.mcmaster.shop.order;

import ca.mcmaster.shop.product.Product;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 5, 2018 2:46:35 PM
 */
public class OrderItem {
	private Integer orderItem_id;
	private Integer orderItem_count;
	private Double orderItem_subtotal;
	private Order orderItem_belonging;
	private Product orderItem_product;
	public Integer getOrderItem_id() {
		return orderItem_id;
	}
	public void setOrderItem_id(Integer orderItem_id) {
		this.orderItem_id = orderItem_id;
	}
	public Integer getOrderItem_count() {
		return orderItem_count;
	}
	public void setOrderItem_count(Integer orderItem_count) {
		this.orderItem_count = orderItem_count;
	}
	public Double getOrderItem_subtotal() {
		return orderItem_subtotal;
	}
	public void setOrderItem_subtotal(Double orderItem_subtotal) {
		this.orderItem_subtotal = orderItem_subtotal;
	}
	public Order getOrderItem_belonging() {
		return orderItem_belonging;
	}
	public void setOrderItem_belonging(Order orderItem_belonging) {
		this.orderItem_belonging = orderItem_belonging;
	}
	public Product getOrderItem_product() {
		return orderItem_product;
	}
	public void setOrderItem_product(Product orderItem_product) {
		this.orderItem_product = orderItem_product;
	}
}
