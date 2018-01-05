package ca.mcmaster.shop.cart;

import ca.mcmaster.shop.product.Product;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 4, 2018 5:17:42 PM
 */
public class CartItem {
	private Product product;
	private Integer count;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return product.getProduct_store_price() * count;
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", count=" + count + "]";
	}
}
