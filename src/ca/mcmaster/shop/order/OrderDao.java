package ca.mcmaster.shop.order;

import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.shop.user.User;
import ca.mcmaster.shop.utils.PageHibernateCallback;
import ca.mcmaster.shop.utils.PageInfoBean;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 5, 2018 2:51:52 PM
 */
public class OrderDao extends HibernateDaoSupport {

	public void saveOrder(Order order) {
		this.getHibernateTemplate().save(order);
	}

	public void removeOrderItembyId(Integer orderItem_id) {
		OrderItem orderItem = this.getHibernateTemplate().get(OrderItem.class,
				orderItem_id);
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

	public Integer findOrderByStatus(Integer status) {
		@SuppressWarnings("unchecked")
		List<Long> count = this.getHibernateTemplate().find(
				"select count(*) from Order where order_status = ?", status);
		if (count != null && count.size() != 0) {
			return count.get(0).intValue();
		}
		return null;
	}

	public List<Order> findAllByStatusAndPage(Integer status,
			PageInfoBean<Order> pageBean) {
		Integer limit = pageBean.getPageLimit();
		Integer current = pageBean.getCurrentPage();
		Integer start = limit * (current - 1);
		List<Order> orders = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(
						"from Order o where o.order_status=?",
						new Object[] { status }, start, limit));
		return orders;
	}
}
