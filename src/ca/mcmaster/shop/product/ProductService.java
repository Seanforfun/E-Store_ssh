package ca.mcmaster.shop.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.shop.level1.Level1;
import ca.mcmaster.shop.level1.Level1Dao;
import ca.mcmaster.shop.utils.PageInfoBean;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 9:33:39 PM
 */
@Transactional
public class ProductService {
	@Resource(name = "productDao")
	private ProductDao productDao;

	@Resource(name = "level1Dao")
	private Level1Dao level1Dao;

	public List<Product> findByHot() {
		List<Product> list = productDao.findByHot();
		return list;
	}

	public List<Product> findByDate() {
		List<Product> list = productDao.findByDate();
		return list;
	}

	public List<Level1> findAllLevel1() {
		List<Level1> level1List = level1Dao.findAll();
		return level1List;
	}

	public PageInfoBean<Product> findProductsByPage(Integer pageNum,
			Integer id, int level) {
		PageInfoBean<Product> pageBean = new PageInfoBean<Product>();
		int limit = 12;
		Integer productTotalNum = 0;
		List<Product> productList = null;
		pageBean.setCurrentPage(pageNum);
		pageBean.setPageLimit(limit);
		if (level == 1) {
			productTotalNum = productDao.findNumByLevel1_id(id);
		}else{
			productTotalNum = productDao.findNumByLevel2_id(id);
		}
		pageBean.setTotalInfo(productTotalNum);
		if (null != productTotalNum) {
			Integer totalPage = 0;
			if (limit >= productTotalNum) {
				totalPage = 1;
			} else {
				Integer remain = productTotalNum % (pageBean.getPageLimit());
				totalPage = productTotalNum / limit;
				if (remain != 0) {
					totalPage = totalPage++;
				}
			}
			pageBean.setTotalPageNum(totalPage);
		}
		Integer begin = (pageNum - 1) * limit;
		if (level == 1) {
			productList = productDao.findLevel1ProductByPage(id,
					begin, limit);
		}else{
			productList = productDao.findLevel2ProductByPage(id,
					begin, limit);
		}
		pageBean.setList(productList);
		return pageBean;
	}

	public Product findProductById(Integer product_id) {
		Product product = productDao.findProductById(product_id);
		return product;
	}
}
