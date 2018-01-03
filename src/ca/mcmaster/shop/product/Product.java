package ca.mcmaster.shop.product;

import java.sql.Date;

import ca.mcmaster.shop.level2.Level2;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 2, 2018 9:23:06 PM
 */
public class Product {
	private Integer product_id;
	private String product_name;
	private Double product_market_price;
	private Double product_store_price;
	private String product_desc;
	private String product_photo;
//	private Level2 product_belonging;
	private Integer product_ishot;
	private Date product_date;
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Double getProduct_market_price() {
		return product_market_price;
	}
	public void setProduct_market_price(Double product_market_price) {
		this.product_market_price = product_market_price;
	}
	public Double getProduct_store_price() {
		return product_store_price;
	}
	public void setProduct_store_price(Double product_store_price) {
		this.product_store_price = product_store_price;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public String getProduct_photo() {
		return product_photo;
	}
	public void setProduct_photo(String product_photo) {
		this.product_photo = product_photo;
	}
//	public Level2 getProduct_belonging() {
//		return product_belonging;
//	}
//	public void setProduct_belonging(Level2 product_belonging) {
//		this.product_belonging = product_belonging;
//	}
	public Integer getProduct_ishot() {
		return product_ishot;
	}
	public void setProduct_ishot(Integer product_ishot) {
		this.product_ishot = product_ishot;
	}
	public Date getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name="
				+ product_name + ", product_market_price="
				+ product_market_price + ", product_store_price="
				+ product_store_price + ", product_desc=" + product_desc
				+ ", product_photo=" + product_photo + ", product_ishot="
				+ product_ishot + ", product_date=" + product_date + "]";
	}
}
