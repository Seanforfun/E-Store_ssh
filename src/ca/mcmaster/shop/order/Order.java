package ca.mcmaster.shop.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ca.mcmaster.shop.user.User;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 5, 2018 2:43:02 PM
 */
public class Order {
	private Integer order_id;
	private Date order_time;
	private String order_address;
	private Double order_total_price;
	/*
	 * 0:not paid; 1:paid 2:not delivered 3:received
	 */
	private String order_receiver;
	private Integer order_status;
	private String order_phone;
	private User order_order_belonging;
	private Set<OrderItem> orderItem_set = new HashSet<OrderItem>();
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public Double getOrder_total_price() {
		return order_total_price;
	}
	public void setOrder_total_price(Double order_total_price) {
		this.order_total_price = order_total_price;
	}
	public String getOrder_receiver() {
		return order_receiver;
	}
	public void setOrder_receiver(String order_receiver) {
		this.order_receiver = order_receiver;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}
	public User getOrder_order_belonging() {
		return order_order_belonging;
	}
	public void setOrder_order_belonging(User order_order_belonging) {
		this.order_order_belonging = order_order_belonging;
	}
	public Set<OrderItem> getOrderItem_set() {
		return orderItem_set;
	}
	public void setOrderItem_set(Set<OrderItem> orderItem_set) {
		this.orderItem_set = orderItem_set;
	}
}
