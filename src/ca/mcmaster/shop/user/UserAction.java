package ca.mcmaster.shop.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import ca.mcmaster.shop.ReturnType.ReturnResult;
import ca.mcmaster.shop.utils.CheckCode;
import ca.mcmaster.shop.utils.CheckCodeUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 5:09:20 PM
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private String time = new String();
	private String checkcode = new String();
	private String repassword;

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

	public String register() throws AddressException, MessagingException {
		userService.register(user);
		this.addActionMessage("Register Success! Please active your account in your e-mail address.");
		return "registerSuccess";
	}
	
	public String active(){
		ReturnResult result = userService.active(user);
		if(result == ReturnResult.SUCCESS){
			this.addActionMessage("Avtivation Success!");
		}else{
			this.addActionMessage("Avtivation Failed!");
		}
		return "activeFinish";
		
	}
}
