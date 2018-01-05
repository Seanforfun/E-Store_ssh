package ca.mcmaster.shop.order;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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

}
