package ca.mcmaster.shop.level1;

import java.util.HashSet;
import java.util.Set;

import ca.mcmaster.shop.level2.Level2;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 7:28:29 PM
 */
public class Level1 {
	private Integer level1_id;
	private String level1_name;
	private Set<Level2> level2_set = new HashSet<Level2>();
	public Integer getLevel1_id() {
		return level1_id;
	}
	public void setLevel1_id(Integer level1_id) {
		this.level1_id = level1_id;
	}
	public String getLevel1_name() {
		return level1_name;
	}
	public void setLevel1_name(String level1_name) {
		this.level1_name = level1_name;
	}
	public Set<Level2> getLevel2_set() {
		return level2_set;
	}
	public void setLevel2_set(Set<Level2> level2_set) {
		this.level2_set = level2_set;
	}
}
