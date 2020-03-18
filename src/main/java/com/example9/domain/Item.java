package com.example9.domain;

import java.util.List;

public class Item {

	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** 説明 */
	private String description;
	/** Mの価格 */
	private Integer price_m;
	/** Lの価格 */
	private Integer price_l;
	/** 画像パス */
	private String image_path;
	/** 削除フラグ */
	private Boolean deleted;
	/** トッピングリスト */
	private List<Topping> toppingList;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public List<Topping> getToppingList() {
		return toppingList;
	}

	public void setToppingList(List<Topping> toppingList) {
		this.toppingList = toppingList;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price_m=" + price_m
				+ ", price_l=" + price_l + ", image_path=" + image_path + ", deleted=" + deleted + ", toppingList="
				+ toppingList + "]";
	}

}
