package ca.mcmaster.shop.product;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 9:33:39 PM
 */
public class ProductService {
	@Resource(name="productDao")
	private ProductDao productDao;

	public List<Product> findByHot() {
		List<Product> list = productDao.findByHot();
		return list;
	}

	public List<Product> findByDate() {
		List<Product> list = productDao.findByDate();
		return list;
	}
}
