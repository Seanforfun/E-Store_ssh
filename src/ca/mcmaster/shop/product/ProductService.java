package ca.mcmaster.shop.product;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.shop.level1.Level1;
import ca.mcmaster.shop.level1.Level1Dao;
import ca.mcmaster.shop.level2.Level2;
import ca.mcmaster.shop.level2.Level2Dao;
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
	
	@Resource(name="level2Dao")
	private Level2Dao level2Dao;

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

	public PageInfoBean<Product> findAllByPage(Integer page) {
		PageInfoBean<Product> pageBean = new PageInfoBean<Product>();
		pageBean.setCurrentPage(page);
		Integer totalInfo = productDao.findAllNum();
		pageBean.setTotalInfo(totalInfo);
		pageBean.setPageLimit(10);
		if(totalInfo % pageBean.getPageLimit() == 0){
			pageBean.setTotalPageNum(totalInfo/pageBean.getPageLimit());
		}else{
			pageBean.setTotalPageNum(totalInfo/pageBean.getPageLimit() + 1);
		}
		List<Product> products = productDao.findAllProductByPage(pageBean);
		if(null != products){
			pageBean.setList(products);
		}
		return pageBean;
	}

	public List<Level2> findAllLevel2() {
		List<Level2> level2s = level2Dao.findAll();
		return level2s;
	}

	public Level2 findLevel2ByName(DetachedCriteria criteria) {
		Level2 level2 = level2Dao.findLevel2ByCriteria(criteria);
		return level2;
	}

	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	public void delete(Product product) {
		productDao.delete(product);
	}

	public void update(Product existProduct) {
		productDao.update(existProduct);
	}
}
