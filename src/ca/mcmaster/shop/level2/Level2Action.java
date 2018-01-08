package ca.mcmaster.shop.level2;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.shop.utils.PageInfoBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 8, 2018 1:33:04 PM
 */
@SuppressWarnings("serial")
public class Level2Action extends ActionSupport implements ModelDriven<Level2> {
	@Resource(name = "level2Service")
	private Level2Service level2Service;
	private Level2 level2 = new Level2();
	private Integer page;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@Override
	public Level2 getModel() {
		return level2;
	}
	
	public String adminFindAllByPage(){
		PageInfoBean<Level2> pageBean = level2Service.findAllByPage(page);
		if(null != pageBean){
			ActionContext.getContext().put("pageBean", pageBean);
		}else{
			this.addActionError("No level2 item found!");
		}
		return "adminFindAllByPageSuccess";
	}
	
	public String deleteById(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Level2.class);
		System.out.println("level2_id" + level2.getLevel2_id());
		criteria.add(Restrictions.eq("level2_id", level2.getLevel2_id()));
		level2Service.deleteByCriteria(criteria);
		return "deleteByIdSuccess";
	}
}
