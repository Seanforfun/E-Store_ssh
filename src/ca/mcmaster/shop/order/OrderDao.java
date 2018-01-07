package ca.mcmaster.shop.order;

import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.shop.user.User;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 5, 2018 2:51:52 PM
 */
public class OrderDao extends HibernateDaoSupport {

	public void saveOrder(Order order) {
		this.getHibernateTemplate().save(order);
	}

	public void removeOrderItembyId(Integer orderItem_id) {
		OrderItem orderItem = this.getHibernateTemplate().get(OrderItem.class, orderItem_id);
		this.getHibernateTemplate().delete(orderItem);
	}

	public Order findOrderByOrder_id(Integer order_id) {
		Order order = this.getHibernateTemplate().get(Order.class, order_id);
		return order;
	}

	public void removeOrderByOrder_id(Integer order_id) {
		Order order = this.getHibernateTemplate().get(Order.class, order_id);
		this.getHibernateTemplate().delete(order);
	}

	public void updateOrder(Order existOrder) {
		this.getHibernateTemplate().update(existOrder);
	}

	public void updateAfterPay(String p2_Order) {
		Order order = this.getHibernateTemplate().get(Order.class, p2_Order);
		order.setOrder_status(1);
	}

	public Set<Order> findOrderByUserId(Integer user_id) {
		User user = this.getHibernateTemplate().load(User.class, user_id);
		Set<Order> orders = user.getOrder_set();
		return orders;
	}
}
