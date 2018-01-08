package ca.mcmaster.shop.level1;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 7:33:37 PM
 */
@Transactional
public class Level1Service {
	@Resource(name="level1Dao")
	private Level1Dao level1Dao;

	public List<Level1> findAll() {
		List<Level1> level1list = level1Dao.findAll();
		return level1list;
	}

	public void add(Level1 level1) {
		level1Dao.add(level1);
	}

	public void deleteById(Integer level1_id) {
		level1Dao.deleteById(level1_id);
	}

	public void update(Level1 level1) {
		level1Dao.update(level1);
	}
}
