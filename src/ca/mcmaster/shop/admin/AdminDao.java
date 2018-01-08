package ca.mcmaster.shop.admin;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 7, 2018 7:54:48 PM
 */
public class AdminDao extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public Admin findAdminByCriteria(DetachedCriteria criteria) {
		 List<Admin> admin = this.getHibernateTemplate().findByCriteria(criteria);
		 if(null != admin && admin.size() != 0){
			 return admin.get(0);
		 }else{
			 return null;
		 }
	}
	
}
