package ca.mcmaster.shop.user;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 8:17:42 PM
 */
public class UserDao extends HibernateDaoSupport {

	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
}
