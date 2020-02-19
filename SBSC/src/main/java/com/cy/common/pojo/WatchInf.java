package com.cy.common.pojo;

import java.io.Serializable;

/**liuxueming优惠页面*/
public class WatchInf implements Serializable {
	private static final long serialVersionUID = 6345904783077538626L;
	private Integer id;
	private String watchImg;
	private String watchName;
	private String watchIntroduce;
	private Double watchPrice;
	private Double watchSale;
	private Integer watchInventory;
	private Integer watchSell;
	private Boolean watchLike;
	private Integer watchComment;
	private Integer watchLevelId;
	private String watchSex;
	@Override
	public String toString() {
		return "WatchInf [id=" + id + ", watchImg=" + watchImg + ", watchName=" + watchName + ", watchIntroduce="
				+ watchIntroduce + ", watchPrice=" + watchPrice + ", watchSale=" + watchSale + ", watchInventory="
				+ watchInventory + ", watchSell=" + watchSell + ", watchLike=" + watchLike + ", watchComment="
				+ watchComment + ", watchLevelId=" + watchLevelId + ", watchSex=" + watchSex + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWatchImg() {
		return watchImg;
	}
	public void setWatchImg(String watchImg) {
		this.watchImg = watchImg;
	}
	public String getWatchName() {
		return watchName;
	}
	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}
	public String getWatchIntroduce() {
		return watchIntroduce;
	}
	public void setWatchIntroduce(String watchIntroduce) {
		this.watchIntroduce = watchIntroduce;
	}
	public Double getWatchPrice() {
		return watchPrice;
	}
	public void setWatchPrice(Double watchPrice) {
		this.watchPrice = watchPrice;
	}
	public Double getWatchSale() {
		return watchSale;
	}
	public void setWatchSale(Double watchSale) {
		this.watchSale = watchSale;
	}
	public Integer getWatchInventory() {
		return watchInventory;
	}
	public void setWatchInventory(Integer watchInventory) {
		this.watchInventory = watchInventory;
	}
	public Integer getWatchSell() {
		return watchSell;
	}
	public void setWatchSell(Integer watchSell) {
		this.watchSell = watchSell;
	}
	public Boolean getWatchLike() {
		return watchLike;
	}
	public void setWatchLike(Boolean watchLike) {
		this.watchLike = watchLike;
	}
	public Integer getWatchComment() {
		return watchComment;
	}
	public void setWatchComment(Integer watchComment) {
		this.watchComment = watchComment;
	}
	public Integer getWatchLevelId() {
		return watchLevelId;
	}
	public void setWatchLevelId(Integer watchLevelId) {
		this.watchLevelId = watchLevelId;
	}
	public String getWatchSex() {
		return watchSex;
	}
	public void setWatchSex(String watchSex) {
		this.watchSex = watchSex;
	}
	
	
}
