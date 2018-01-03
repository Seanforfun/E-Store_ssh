package ca.mcmaster.shop.product;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 9:32:59 PM
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {

	private Product product = new Product();
	@Override
	public Product getModel() {
		return product;
	}

}
