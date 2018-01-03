package ca.mcmaster.shop.product;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.shop.utils.PageHibernateCallback;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 9:33:47 PM
 */
public class ProductDao extends HibernateDaoSupport{

	public List<Product> findByHot() {
		@SuppressWarnings("unchecked")
		List<Product> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<Product>("from Product where product_ishot = ?", new Object[]{1}, 0, 10));
		return list;
	}

	public List<Product> findByDate() {
		@SuppressWarnings("unchecked")
		List<Product> list = this.getHibernateTemplate().executeFind(new PageHibernateCallback<Product>("from Product order by product_date desc", null, 0, 10));
		return list;
	}
}
