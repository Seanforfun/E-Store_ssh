package ca.mcmaster.shop.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 8:17:42 PM
 */
public class UserDao extends HibernateDaoSupport {

	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	public User getUserByActiveCode(String user_activative_code) {
		@SuppressWarnings("unchecked")
		List<User> list = this.getHibernateTemplate().find("from User where user_activative_code = ?", user_activative_code);
		return list.get(0);
	}

	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	/**
	 * @param criteria
	 * @return
	 */
	public User getUserByRestriction(DetachedCriteria criteria) {
		@SuppressWarnings("unchecked")
		List<User> list = this.getHibernateTemplate().findByCriteria(criteria);
		return list.get(0);
	}
}
