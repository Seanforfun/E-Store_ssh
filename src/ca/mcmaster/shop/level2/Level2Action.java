package ca.mcmaster.shop.level2;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.shop.level1.Level1;
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
	private String level2_belongname;
	
	public String getLevel2_belongname() {
		return level2_belongname;
	}

	public void setLevel2_belongname(String level2_belongname) {
		this.level2_belongname = level2_belongname;
	}

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
	
	public String addPre(){
		List<Level1> level1s = level2Service.findAllLevel1();
		if(null == level1s || level1s.size()== 0){
			this.addActionError("Please add Level1 menu first!");
			return "addPreNoLevel1Failed";
		}
		List<String> level1Names = new ArrayList<String>();
		for(Level1 l : level1s){
			level1Names.add(l.getLevel1_name());
		}
		ActionContext.getContext().put("level1s", level1Names);
		return "addPreSuccess";
	}
	
	public String addAfter(){
		Level1 level1 = level2Service.findLevel1ByName(level2_belongname);
		if(level1 == null){
			this.addActionError("Selceted level1 doesn't exist!");
			return "addAfterFailed";
		}
		level2.setLevel2_belonging(level1);
		level2Service.addLevel2(level2);
		return "addAfterSuccess";
	}
}
