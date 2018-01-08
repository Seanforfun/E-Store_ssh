package ca.mcmaster.shop.level2;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;

import ca.mcmaster.shop.utils.PageInfoBean;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 8, 2018 1:34:40 PM
 */
@Transactional
public class Level2Service {
	@Resource(name = "level2Dao")
	private Level2Dao level2Dao;

	public PageInfoBean<Level2> findAllByPage(Integer page) {
		PageInfoBean<Level2> pageBean = new PageInfoBean<Level2>();
		pageBean.setCurrentPage(page);
		pageBean.setPageLimit(5);
		int total = level2Dao.findTotalNum();
		pageBean.setTotalInfo(total);
		if(total % pageBean.getPageLimit() == 0){
			pageBean.setTotalPageNum(total / pageBean.getPageLimit());
		}else{
			pageBean.setTotalPageNum(total / pageBean.getPageLimit() + 1);
		}
		List<Level2> level2s = level2Dao.findAllByPage(pageBean);
		pageBean.setList(level2s);
		return pageBean;
	}

	public void deleteByCriteria(DetachedCriteria criteria) {
		level2Dao.deleteByCriteria(criteria);
	}
}
