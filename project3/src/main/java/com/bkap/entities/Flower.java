package com.bkap.entities;

import java.sql.Date;

public class Flower {
	private String flowerId;
	private String flowerName;
	private String unit;
	private float price;
	private float priceOld;
	private String brief;
	private String description;
	private String picture;
	private Date createDate;
	private boolean active;
	public Flower() {
		
	}
	public Flower(String flowerId, String flowerName, String unit, float price, float priceOld, String brief,
			String description, String picture, Date createDate, boolean active) {
		super();
		this.flowerId = flowerId;
		this.flowerName = flowerName;
		this.unit = unit;
		this.price = price;
		this.priceOld = priceOld;
		this.brief = brief;
		this.description = description;
		this.picture = picture;
		this.createDate = createDate;
		this.active = active;
	}

	public String getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(String flowerId) {
		this.flowerId = flowerId;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPriceOld() {
		return priceOld;
	}
	public void setPriceOld(float priceOld) {
		this.priceOld = priceOld;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
