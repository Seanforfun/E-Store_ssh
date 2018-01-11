package ca.mcmaster.shop.order;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.shop.utils.PageInfoBean;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 5, 2018 2:52:03 PM
 */
@Transactional
public class OrderService {
	@Resource(name="orderDao")
	private OrderDao orderDao;

	public void saveOrder(Order order) {
		orderDao.saveOrder(order);
	}

	public void removeOrderItembyId(Integer orderItem_id) {
		orderDao.removeOrderItembyId(orderItem_id);
	}

	public Order findOrderByOrder_id(Integer order_id) {
		Order order= orderDao.findOrderByOrder_id(order_id);
		return order;
	}

	public void removeOrderByOrder_id(Integer order_id) {
		orderDao.removeOrderByOrder_id(order_id);
	}

	public void updateOrder(Order existOrder) {
		orderDao.updateOrder(existOrder);
	}

	public void updateAfterPay(String p2_Order) {
		orderDao.updateAfterPay(p2_Order);
	}

	public Set<Order> findOrderByUserId(Integer user_id) {
		Set<Order> orders = orderDao.findOrderByUserId(user_id);
		return orders;
	}

	public PageInfoBean<Order> findAll(Integer status, Integer page) {
		PageInfoBean<Order> pageBean = new PageInfoBean<Order>();
		pageBean.setCurrentPage(page);
		pageBean.setPageLimit(10);
		Integer total = orderDao.findOrderByStatus(status);
		if(total != null){
			pageBean.setTotalInfo(total);
			if(total % pageBean.getPageLimit() == 0){
				pageBean.setTotalPageNum(total / pageBean.getPageLimit());
			}else{
				pageBean.setTotalPageNum(total / pageBean.getPageLimit() + 1 );
			}
			List<Order> orders = orderDao.findAllByStatusAndPage(status, pageBean);
			pageBean.setList(orders);
		}
		return pageBean;
	}
}
