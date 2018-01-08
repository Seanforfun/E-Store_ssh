package ca.mcmaster.shop.admin;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 7, 2018 7:52:04 PM
 */
@SuppressWarnings("serial")
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	private Admin admin = new Admin();
	@Resource(name="adminService")
	private AdminService adminService;
	@Override
	public Admin getModel() {
		return admin;
	}

	public String login(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Admin.class);
		criteria.add(Restrictions.eq("admin_name", admin.getAdmin_name())).add(Restrictions.eq("admin_password", admin.getAdmin_password()));
		Admin existAdmin = adminService.login(criteria);
		if(null != existAdmin){
			ActionContext.getContext().getSession().put("userInfo", existAdmin);
			return "loginSuccess";
		}else {
			this.addActionError("Admin user doesn't exist");
			return "loginFailed";
		}
	}
}
