package ca.mcmaster.shop.order;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

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
}
