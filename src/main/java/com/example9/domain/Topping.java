package com.example9.domain;

public class Topping {

	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** Mの価格 */
	private Integer price_m;
	/** Lの価格 */
	private Integer price_l;

	@Override
	public String toString() {
		return "Topping [id=" + id + ", name=" + name + ", price_m=" + price_m + ", price_L=" + price_l + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice_m() {
		return price_m;
	}

	public void setPrice_m(Integer price_m) {
		this.price_m = price_m;
	}

	public Integer getPrice_l() {
		return price_l;
	}

	public void setPrice_l(Integer price_l) {
		this.price_l = price_l;
	}

}
