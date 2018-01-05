package ca.mcmaster.shop.cart;

import java.util.Map;

import javax.annotation.Resource;

import ca.mcmaster.shop.product.Product;
import ca.mcmaster.shop.product.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 4, 2018 5:51:12 PM
 */
@SuppressWarnings("serial")
public class CartAction extends ActionSupport implements ModelDriven<CartItem> {

	private CartItem cartItem = new CartItem();
	private Integer product_id;
	@Resource(name="productService")
	private ProductService productService;
	@Resource(name="cart")
	private Cart cart;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	@Override
	public CartItem getModel() {
		return cartItem;
	}
	
	public String addProductToCart(){
		Product product = productService.findProductById(product_id);
		if(null != product){
			cartItem.setProduct(product);
			Map<String, Object> session = ActionContext.getContext().getSession();
			if(!session.containsKey("cart")){
				cart.addProduct2Cart(cartItem);
				session.put("cart", cart);
			}else{
				Cart existCart = (Cart) session.get("cart");
				existCart.addProduct2Cart(cartItem);
			}
		}
		return "addProductToCartSuccess";
	}
}
