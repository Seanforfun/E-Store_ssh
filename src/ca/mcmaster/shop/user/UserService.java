package ca.mcmaster.shop.user;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.shop.utils.UUIDUtils;

/**
 * @author SeanForFun email:xiaob6@mcmaster.ca
 * @version Jan 1, 2018 8:16:38 PM
 */
@Transactional
public class UserService {
	@Resource(name="userDao")
	private UserDao userDao;

	/**
	 * @Description 
	 * 1. Save user.
	 * 2. Send e-mail.
	 */
	public void register(User user) {
		user.setUser_status(0);
		user.setUser_activative_code(UUIDUtils.getUUID());
		userDao.save(user);
	}
}
