package ca.mcmaster.shop.level2;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.shop.utils.PageHibernateCallback;
import ca.mcmaster.shop.utils.PageInfoBean;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 8, 2018 1:35:23 PM
 */
public class Level2Dao extends HibernateDaoSupport {

	public List<Level2> findAllByPage(PageInfoBean<Level2> pageBean) {
		List<Level2> level2s = this.getHibernateTemplate().execute(new PageHibernateCallback<Level2>("from Level2", null, ((pageBean.getCurrentPage() - 1) * pageBean.getPageLimit()), pageBean.getPageLimit()));
		return level2s;
	}

	@SuppressWarnings("unchecked")
	public int findTotalNum() {
		List<Long> count = this.getHibernateTemplate().find("select count(*) from Level2");
		if(count != null && count.size() != 0){
			return count.get(0).intValue();
		}else {
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public void deleteByCriteria(DetachedCriteria criteria) {
		List<Level2> level2s = this.getHibernateTemplate().findByCriteria(criteria);
		if(level2s != null && level2s.size() != 0){
			this.getHibernateTemplate().delete(level2s.get(0));
		}
	}

	public void add(Level2 level2) {
		this.getHibernateTemplate().save(level2);
	}

	@SuppressWarnings("unchecked")
	public Level2 findLevel2ByCriteria(DetachedCriteria criteria) {
		List<Level2> level2s = this.getHibernateTemplate().findByCriteria(criteria);
		if(null != level2s && level2s.size() != 0){
			return level2s.get(0);
		}
		return null;
	}

	public void update(Level2 level2) {
		this.getHibernateTemplate().update(level2);
	}
}
