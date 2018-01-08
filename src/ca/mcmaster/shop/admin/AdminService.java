package ca.mcmaster.shop.admin;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 7, 2018 7:54:25 PM
 */
@Transactional
public class AdminService {
	@Resource(name="adminDao")
	private AdminDao adminDao;

	public Admin login(DetachedCriteria criteria) {
		Admin admin = adminDao.findAdminByCriteria(criteria);
		return admin;
	}
}
