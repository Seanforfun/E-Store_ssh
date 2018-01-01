package ca.mcmaster.shop.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Seanforfun
 * @version 2018年1月1日 上午12:24:09
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}
	
	public String registerPage(){
		return "registerPageSuccess";
	}
}
