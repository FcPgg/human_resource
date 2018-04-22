package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_seller_attachment")
public class MtSellerAttachment extends BaseEntity {
	
		
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int sellerId;
	
	@Column(name = "att_id", columnDefinition = "int(11)")
	private int attId;
	
	@Column(name = "category", columnDefinition = "int(11)")
	private int category;
	
	
	public int getSellerId(){
		return this.sellerId;
	}
	
	public void setSellerId(int sellerId){
		this.sellerId = sellerId;
	}
	
	public int getAttId(){
		return this.attId;
	}
	
	public void setAttId(int attId){
		this.attId = attId;
	}
	
	public int getCategory(){
		return this.category;
	}
	
	public void setCategory(int category){
		this.category = category;
	}
	
}
