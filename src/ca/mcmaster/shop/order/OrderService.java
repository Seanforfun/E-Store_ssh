package ca.mcmaster.shop.order;

import javax.annotation.Resource;

/**
 * @author Seanforfun
 * @version 2018年1月5日 上午1:20:12
 */
public class OrderService {
	@Resource(name="orderDao")
	private OrderDao orderDao;

	public void saveOrder(Order order) {
		orderDao.saveOrder(order);
	}
}
