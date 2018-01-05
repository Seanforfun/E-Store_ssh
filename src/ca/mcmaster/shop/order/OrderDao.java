package ca.mcmaster.shop.order;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Seanforfun
 * @version 2018年1月5日 上午1:22:28
 */
public class OrderDao extends HibernateDaoSupport {

	public void saveOrder(Order order) {
		this.getHibernateTemplate().save(order);
	}

}
