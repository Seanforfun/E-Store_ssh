package ca.mcmaster.shop.user;

import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.shop.ReturnType.ReturnResult;
import ca.mcmaster.shop.utils.MailUtils;
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
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @Description 
	 * 1. Save user.
	 * 2. Send e-mail.
	 */
	public void register(User user) throws AddressException, MessagingException {
		user.setUser_status(0);
		user.setUser_activative_code(UUIDUtils.getUUID());
		userDao.save(user);
		if(null != user.getUser_email()){
			MailUtils.sendActiveEmail(user);
		}
	}

	public ReturnResult active(User user) {
		User retUser = userDao.getUserByActiveCode(user.getUser_activative_code());
		if(null != retUser){
			retUser.setUser_status(1);
			userDao.update(retUser);
			return ReturnResult.SUCCESS;
		}else {
			return ReturnResult.FAILED;
		}
	}

	/**
	 * @param criteria
	 * @return
	 */
	public User login(DetachedCriteria criteria) {
		User ret = userDao.getUserByRestriction(criteria);
		return ret;
	}

	public List<User> getUserByUsername(String username) {
		List<User> list = userDao.getUserByUsername(username);
		return list;
	}
}
