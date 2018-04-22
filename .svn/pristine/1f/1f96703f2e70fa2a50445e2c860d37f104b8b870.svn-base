package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_goods_spec")
public class MtGoodsSpec extends BaseEntity {
	
	
	@Column(name = "description", columnDefinition = "varchar(200)")
	private String description;
	
	@Column(name = "price", columnDefinition = "decimal(18,2)")
	private double price;
	
	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;
	
	@Column(name = "inventory", columnDefinition = "int(11)")
	private int inventory;
	
	@Column(name = "warn_number", columnDefinition = "int(11)")
	private int warnNumber;
	
	@Column(name = "resource_id", columnDefinition = "int(11)")
	private int resourceId;
	
	@Formula("(select t.access_url from mt_material_resources t where t.id = resource_id)")
	private String resourceAccessUrl;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice(){
		return this.price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public int getGoodsId(){
		return this.goodsId;
	}
	
	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}
	
	public int getInventory(){
		return this.inventory;
	}
	
	public void setInventory(int inventory){
		this.inventory = inventory;
	}
	
	public int getWarnNumber(){
		return this.warnNumber;
	}
	
	public void setWarnNumber(int warnNumber){
		this.warnNumber = warnNumber;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceAccessUrl() {
		return resourceAccessUrl;
	}

	public void setResourceAccessUrl(String resourceAccessUrl) {
		this.resourceAccessUrl = resourceAccessUrl;
	}
}
