package ca.mcmaster.shop.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

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
	
	public String verify() throws IOException{
		String correct = (String)ServletActionContext.getContext().getSession().get("verify");
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(correct);
		System.out.println(checkcode);
		if(checkcode.toLowerCase().equals(correct.toLowerCase())){
			map.put("result", "true");
		}else{
			map.put("result", "Code doesn't match!");
		}
		JSONObject jsonObject = JSONObject.fromObject(map);
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
		return NONE;
	}
	
}
