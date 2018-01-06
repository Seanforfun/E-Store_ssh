package ca.mcmaster.shop.level1;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 8:24:48 PM
 */
@SuppressWarnings("serial")
public class Level1Action extends ActionSupport implements ModelDriven<Level1> {

	private Level1 level1 = new Level1();
	
	@Override
	public Level1 getModel() {
		return level1;
	}

}
