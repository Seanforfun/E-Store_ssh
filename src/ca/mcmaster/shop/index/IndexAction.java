package ca.mcmaster.shop.index;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import ca.mcmaster.shop.level1.Level1;
import ca.mcmaster.shop.level1.Level1Service;
import ca.mcmaster.shop.product.Product;
import ca.mcmaster.shop.product.ProductService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 31, 2017 10:25:47 PM
 */
@SuppressWarnings("serial")
public class IndexAction extends ActionSupport {
	@Resource(name = "level1Service")
	private Level1Service level1Service;
	@Resource(name = "productService")
	private ProductService productService;
	private List<Product> hotList;
	private List<Product> newList;

	public List<Product> getHotList() {
		return hotList;
	}

	public void setHotList(List<Product> hotList) {
		this.hotList = hotList;
	}

	public List<Product> getNewList() {
		return newList;
	}

	public void setNewList(List<Product> newList) {
		this.newList = newList;
	}
	
	public String execute() {
		List<Level1> level1List = level1Service.findAll();
		if (null != level1List) {
			ServletActionContext.getContext().getSession()
					.put("level1List", level1List);
		}
		hotList = productService.findByHot();
		newList = productService.findByDate();
		for(Product p : newList){
			System.out.println(p);
		}
		return "indexSuccess";
	}
}
