package ca.mcmaster.shop.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.shop.level1.Level1;
import ca.mcmaster.shop.level2.Level2;
import ca.mcmaster.shop.utils.PageInfoBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 9:32:59 PM
 */
@SuppressWarnings("serial")
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	@Resource(name = "productService")
	private ProductService productService;
	private Integer pageNum;
	private Integer level1_id;
	private Integer level2_id;
	private Integer level_id;
	private Integer level;
	private Integer page;
	private String level2_name;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	public String getLevel2_name() {
		return level2_name;
	}

	public void setLevel2_name(String level2_name) {
		this.level2_name = level2_name;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLevel_id() {
		return level_id;
	}

	public void setLevel_id(Integer level_id) {
		this.level_id = level_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getLevel1_id() {
		return level1_id;
	}

	public void setLevel1_id(Integer level1_id) {
		this.level1_id = level1_id;
	}

	public Integer getLevel2_id() {
		return level2_id;
	}

	public void setLevel2_id(Integer level2_id) {
		this.level2_id = level2_id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	private Product product = new Product();

	@Override
	public Product getModel() {
		return product;
	}

	public String findProductById() {
		List<Level1> level1List = productService.findAllLevel1();
		ActionContext.getContext().put("level1List", level1List);
		product = productService.findProductById(product.getProduct_id());
		if (null != product) {
			return "findProductByIdSuccess";
		} else {
			return "findProductByIdFail";
		}
	}

	public String findProductBylevel1_id() {
		level = 1;
		// Find all of level1
		List<Level1> level1List = productService.findAllLevel1();
		ActionContext.getContext().put("level1List", level1List);
		// Find all products under level1
		PageInfoBean<Product> pageBean = productService.findProductsByPage(
				pageNum, level1_id, 1);
		ActionContext.getContext().put("pageBean", pageBean);
		return "findProductBylevel1_idSuccess";
	}

	public String findProductBylevel2_id() {
		level = 2;
		List<Level1> level1List = productService.findAllLevel1();
		ActionContext.getContext().put("level1List", level1List);
		PageInfoBean<Product> pageBean = productService.findProductsByPage(
				pageNum, level2_id, 2);
		ActionContext.getContext().put("pageBean", pageBean);
		return "findProductBylevel2_idSuccess";
	}

	public String findProductByLevel() {
		List<Level1> level1List = productService.findAllLevel1();
		ActionContext.getContext().put("level1List", level1List);
		PageInfoBean<Product> pageBean = null;
		if (level == 1) {
			level1_id = level_id;
			pageBean = productService.findProductsByPage(pageNum, level_id, 1);
		} else {
			level2_id = level_id;
			pageBean = productService.findProductsByPage(pageNum, level_id, 2);
		}
		ActionContext.getContext().put("pageBean", pageBean);
		return "findProductByLevelSuccess";
	}

	public String adminFindAllByPage() {
		PageInfoBean<Product> pageBean = productService.findAllByPage(page);
		if(null != pageBean){
			ActionContext.getContext().put("pageBean", pageBean);
		}
		return "adminFindAllByPageSuccess";
	}
	
	public String addPre(){
		List<Level2> level2s = productService.findAllLevel2();
		List<String> level2Names = new ArrayList<String>();
		for(Level2 l : level2s){
			level2Names.add(l.getLevel2_name());
		}
		ActionContext.getContext().put("level2s", level2Names);
		return "addPreSuccess";
	}
	
	public String addPost() throws IOException{
		String realPath = ServletActionContext.getServletContext().getRealPath("/products");
		DetachedCriteria criteria = DetachedCriteria.forClass(Level2.class);
		criteria.add(Restrictions.eq("level2_name", level2_name));
		Level2 level2 = productService.findLevel2ByName(criteria);
		product.setProduct_belonging(level2);
		if(level2 != null){
			realPath = realPath.concat("\\" + level2.getLevel2_id().toString() + "\\" + uploadFileName);
			System.out.println(realPath);
			File diskFile = new File(realPath);
			FileUtils.copyFile(upload, diskFile);
			product.setProduct_photo("products/" + level2.getLevel2_id().toString() + "/" + uploadFileName);
			productService.addProduct(product);
		}
		return "addPostSuccess";
	}
	
	public String delete(){
		productService.delete(product);
		return "deleteSuccess";
	}
}
