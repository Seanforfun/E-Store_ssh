package ca.mcmaster.shop.index;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 31, 2017 10:25:47 PM
 */
@SuppressWarnings("serial")
public class IndexAction extends ActionSupport {
	
	public String execute(){
		return "indexSuccess";
	}
}
