package ca.mcmaster.shop.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.Cookie;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.shop.ReturnType.ReturnResult;
import ca.mcmaster.shop.utils.CheckCode;
import ca.mcmaster.shop.utils.CheckCodeUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 5:09:20 PM
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private String time = new String();
	private String checkcode = new String();
	private String repassword;
	private String isRememberUsername;

	public void setIsRememberUsername(String isRememberUsername) {
		this.isRememberUsername = isRememberUsername;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Resource(name = "userService")
	private UserService userService;

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public User getModel() {
		return user;
	}

	public String registerPage() {
		return "registerPageSuccess";
	}

	public String checkcode() throws IOException {
		CheckCode code = CheckCodeUtils.drawCheckcode();
		ServletActionContext.getContext().getSession()
				.put("verify", code.getCheckCode());
		ImageIO.write(code.getBufferedImage(), "jpg", ServletActionContext
				.getResponse().getOutputStream());
		return null;
	}

	public String verify() throws IOException {
		String correct = (String) ServletActionContext.getContext()
				.getSession().get("verify");
		Map<String, String> map = new HashMap<String, String>();
		if (checkcode.toLowerCase().equals(correct.toLowerCase())) {
			map.put("result", "true");
		} else {
			map.put("result", "Checkcode doesn't match!");
		}
		JSONObject jsonObject = JSONObject.fromObject(map);
		ServletActionContext.getResponse().getWriter()
				.println(jsonObject.toString());
		return NONE;
	}

	@InputConfig(resultName = "registerInput")
	public String register() throws AddressException, MessagingException {
		userService.register(user);
		this.addActionMessage("Register Success! Please active your account in your e-mail address.");
		return "registerSuccess";
	}

	public String active() {
		ReturnResult result = userService.active(user);
		if (result == ReturnResult.SUCCESS) {
			this.addActionMessage("Avtivation Success!");
		} else {
			this.addActionMessage("Avtivation Failed!");
		}
		return "activeFinish";

	}

	public String loginPage() {
		return "loginPageSuccess";
	}

	@InputConfig(resultName = "loginInput")
	public String login() {
		String correct = (String) ServletActionContext.getContext()
				.getSession().get("verify");
		if(null != checkcode){
			if(checkcode.toUpperCase().equals(correct.toUpperCase())){
				if (isRememberUsername != null && isRememberUsername.equals("true")) {
					boolean remember = false;
					Cookie[] cookies = ServletActionContext.getRequest().getCookies();
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("remember")) {
							remember = true;
							break;
						}
					}

					if (remember == false) {
						Cookie cookie = new Cookie("remember", user.getUser_username());
						ServletActionContext.getResponse().addCookie(cookie);
					}
				}
				DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
				criteria.add(Restrictions.eq("user_username", user.getUser_username()))
						.add(Restrictions.eq("user_password", user.getUser_password()))
						.add(Restrictions.eq("user_status", 1));
				User ret = userService.login(criteria);
				if (ret == null) {
					this.addActionError("Login Failed! Try again!");
					return "loginInput";
				} else {
					Map<String, Object> session = ServletActionContext.getContext()
							.getSession();
					session.put("existUser", ret);
					return "loginSuccess";
				}
			}else {
				this.addActionError("Login failed! Incorrent checkcode!");
				return "loginInput"; 
			}
		}else {
			this.addActionError("Please fill all terms!");
			return "loginInput"; 
		}
	}

	public String checkUsernameExist() throws IOException {
		List<User> list = userService
				.getUserByUsername(user.getUser_username());
		System.out.println(list);
		if (!list.isEmpty()) {
			ServletActionContext.getResponse().getWriter()
					.println("<font color='red'>Invalid username!</font>");
		} else {
			ServletActionContext.getResponse().getWriter()
					.println("<font color='green'>Valid username!</font>");
		}
		return null;
	}
	
	public String exit(){
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		User existUser = (User) session.get("existUser");
		if(null != existUser){
			session.remove("existUser");
		}
		return "exitSuccess";
	}
}
