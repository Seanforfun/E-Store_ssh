package ca.mcmaster.shop.cart;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 4, 2018 5:20:36 PM
 */
public class Cart {
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	private Double total = 0d;

	public Map<Integer, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void addProduct2Cart(CartItem item) {
		if (!map.containsKey(item.getProduct().getProduct_id())) {
			map.put(item.getProduct().getProduct_id(), item);
		} else {
			CartItem original = map.get(item.getProduct().getProduct_id());
			original.setCount(original.getCount() + item.getCount());
		}
		total += item.getSubtotal();
	}

	public void removeProductFromCart(Integer id) {
		CartItem remove = map.remove(id);
		total -= remove.getSubtotal();
	}

	public void clearCart() {
		map.clear();
		total = 0d;
	}
}
