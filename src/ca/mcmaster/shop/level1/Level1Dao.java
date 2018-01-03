package ca.mcmaster.shop.level1;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 7:33:46 PM
 */
public class Level1Dao extends HibernateDaoSupport{

	public List<Level1> findAll() {
		@SuppressWarnings("unchecked")
		List<Level1> level1List = this.getHibernateTemplate().find("from Level1");
		return level1List;
	}

}
