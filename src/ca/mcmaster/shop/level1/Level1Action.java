package ca.mcmaster.shop.level1;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 8:24:48 PM
 */
@SuppressWarnings("serial")
public class Level1Action extends ActionSupport implements ModelDriven<Level1> {

	private Level1 level1 = new Level1();
	@Resource(name="level1Service")
	private Level1Service level1Service;
	@Override
	public Level1 getModel() {
		return level1;
	}

	public String adminFindAll(){
		List<Level1> level1s = level1Service.findAll();
		ActionContext.getContext().put("level1list", level1s);
		return "adminFindAllSuccess";
	}
	
	public String add(){
		level1Service.add(level1);
		return "addLevel1Success";
	}
	
	public String deleteById(){
		level1Service.deleteById(level1.getLevel1_id());
		return "deleteByIdSuccess";
	}
	
	public String editByIdPre(){
		level1 = getModel();
		System.out.println(level1.getLevel1_name());
		return "editByIdPreSuccess";
	}
	
	public String editByIdPrePost(){
		level1Service.update(level1);
		return "editByIdPrePostSuccess";
	}
}
