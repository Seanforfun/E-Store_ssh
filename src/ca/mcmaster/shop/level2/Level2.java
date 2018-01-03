package ca.mcmaster.shop.level2;

import ca.mcmaster.shop.level1.Level1;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 7:59:41 PM
 */
public class Level2 {
	private Integer level2_id;
	private String level2_name;
	private Level1 level2_belonging;
	public Integer getLevel2_id() {
		return level2_id;
	}
	public void setLevel2_id(Integer level2_id) {
		this.level2_id = level2_id;
	}
	public String getLevel2_name() {
		return level2_name;
	}
	public void setLevel2_name(String level2_name) {
		this.level2_name = level2_name;
	}
	public Level1 getLevel2_belonging() {
		return level2_belonging;
	}
	public void setLevel2_belonging(Level1 level2_belonging) {
		this.level2_belonging = level2_belonging;
	}
}
