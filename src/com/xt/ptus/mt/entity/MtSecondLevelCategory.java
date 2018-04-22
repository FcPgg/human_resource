package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_second_level_category")
public class MtSecondLevelCategory extends BaseEntity {
	
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int sellerId;
	
	@Column(name = "category_name", columnDefinition = "varchar(50)")
	private String categoryName;
	
	
	
	public int getSellerId(){
		return this.sellerId;
	}
	
	public void setSellerId(int sellerId){
		this.sellerId = sellerId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
