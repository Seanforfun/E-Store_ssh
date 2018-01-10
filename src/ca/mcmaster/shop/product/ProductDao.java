package ca.mcmaster.shop.product;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.shop.utils.PageHibernateCallback;
import ca.mcmaster.shop.utils.PageInfoBean;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 9:33:47 PM
 */
public class ProductDao extends HibernateDaoSupport {

	public List<Product> findByHot() {
		@SuppressWarnings("unchecked")
		List<Product> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<Product>(
						"from Product where product_ishot = ?",
						new Object[] { 1 }, 0, 10));
		return list;
	}

	public List<Product> findByDate() {
		@SuppressWarnings("unchecked")
		List<Product> list = this.getHibernateTemplate()
				.executeFind(
						new PageHibernateCallback<Product>(
								"from Product order by product_date desc",
								null, 0, 10));
		return list;
	}

	public Integer findNumByLevel1_id(Integer level1_id) {
		@SuppressWarnings("unchecked")
		List<Long> countList = this
				.getHibernateTemplate()
				.find("select count(*) from Product p join p.product_belonging  pb join pb.level2_belonging pb1 with pb1.level1_id = ?",
						level1_id);
		return countList.get(0).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Product> findLevel1ProductByPage(Integer level1_id,
			Integer begin, int limit) {
		List<Product> pageProduct = this
				.getHibernateTemplate()
				.executeFind(
						new PageHibernateCallback<Product>(
								"select p from Product p, Level2 level where p.product_belonging = level and level.level2_belonging.level1_id = ?",
								new Object[] { level1_id }, begin, limit));
		return pageProduct;
	}

	public Product findProductById(Integer product_id) {
		Product product = this.getHibernateTemplate().get(Product.class,
				product_id);
		return product;
	}

	public Integer findNumByLevel2_id(Integer id) {
		@SuppressWarnings("unchecked")
		List<Long> list = this
				.getHibernateTemplate()
				.find("select count(*) from Product p, Level2 lvl where p.product_belonging = lvl and lvl.level2_id = ?",
						id);
		return list.get(0).intValue();
	}

	public List<Product> findLevel2ProductByPage(Integer id, Integer begin,
			int limit) {
		@SuppressWarnings("unchecked")
		List<Product> list = this
				.getHibernateTemplate()
				.executeFind(
						new PageHibernateCallback<>(
								"select p from Product p, Level2 lvl where p.product_belonging = lvl and lvl.level2_id = ?",
								new Object[] { id }, begin, limit));
		return list;
	}

	@SuppressWarnings("unchecked")
	public Integer findAllNum() {
		List<Long> list = this.getHibernateTemplate().find(
				"select count(*) from Product");
		if (null != list && list.size() != 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	public List<Product> findAllProductByPage(PageInfoBean<Product> pageBean) {
		Integer currentPage = pageBean.getCurrentPage();
		Integer pageLimit = pageBean.getPageLimit();
		List<Product> products = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>("from Product", null,
						(pageLimit * (currentPage - 1)), pageLimit));
		return products;
	}

	public void addProduct(Product product) {
		this.getHibernateTemplate().save(product);
	}

	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	public void update(Product existProduct) {
		this.getHibernateTemplate().update(existProduct);
	}
}
