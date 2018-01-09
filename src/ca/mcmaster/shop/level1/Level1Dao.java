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

	public void add(Level1 level1) {
		this.getHibernateTemplate().save(level1);
	}

	public void deleteById(Integer level1_id) {
		Level1 level1 = this.getHibernateTemplate().get(Level1.class, level1_id);
		this.getHibernateTemplate().delete(level1);
	}

	public void update(Level1 level1) {
		this.getHibernateTemplate().update(level1);
	}

	@SuppressWarnings("unchecked")
	public Level1 findByName(String level2_belongname) {
		List<Level1> level1s = this.getHibernateTemplate().find("from Level1 where level1_name = ?", level2_belongname);
		if(level1s.size() != 0 && level1s != null){
			return level1s.get(0);
		}
		return null;
	}

}
