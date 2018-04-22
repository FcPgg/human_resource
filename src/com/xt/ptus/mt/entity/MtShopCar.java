package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_shop_car")
public class MtShopCar extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int sellerId;
	
	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;
	
	@Column(name = "goods_spec_id", columnDefinition = "int(11)")
	private int goodsSpecId;
	
	@Column(name = "goods_number", columnDefinition = "int(11)")
	private int goodsNumber;
	
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getGoodsId(){
		return this.goodsId;
	}
	
	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}
	
	public int getGoodsSpecId(){
		return this.goodsSpecId;
	}
	
	public void setGoodsSpecId(int goodsSpecId){
		this.goodsSpecId = goodsSpecId;
	}
	
	public int getGoodsNumber(){
		return this.goodsNumber;
	}
	
	public void setGoodsNumber(int goodsNumber){
		this.goodsNumber = goodsNumber;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
