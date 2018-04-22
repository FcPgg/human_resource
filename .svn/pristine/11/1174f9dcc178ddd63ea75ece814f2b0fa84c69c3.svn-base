package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_integrate_exchange_log")
public class MtIntegrateExchangeLog extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;
	
	@Column(name = "count", columnDefinition = "int(11)")
	private int count;
	
	@Column(name = "exchange_time", columnDefinition = "datetime")
	private Date exchangeTime;
	
	@Column(name = "status", columnDefinition = "int(11)")
	private int status;
	
	@Column(name = "tracking_company", columnDefinition = "varchar(20)")
	private String trackingCompany;
	
	@Column(name = "tracking_no", columnDefinition = "varchar(100)")
	private String trackingNo;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;
	
	@Column(name = "receivor", columnDefinition = "varchar(50)")
	private String receivor;
	
	@Column(name = "address", columnDefinition = "varchar(500)")
	private String address;
	
	@Column(name = "phone_number", columnDefinition = "varchar(20)")
	private String phoneNumber;
	
	@Column(name = "price" , columnDefinition = "int(11)")
	private int price;
	
	@Column(name = "goodName" , columnDefinition = "varchar(100)")
	private String goodName;
	
	@Formula(value="(select a.description from sys_dictionarys_data a where a.dictionary_id =  (select b.id from sys_dictionarys b where b.code = 'mtIntegrateExchangeLog') and a.code = status )")
	private String statusName;
	
	
	
	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getGoodsId(){
		return this.goodsId;
	}
	
	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}
	
	public int getCount(){
		return this.count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 
	public Date getExchangeTime(){
		return this.exchangeTime;
	}
	
	public void setExchangeTime(Date exchangeTime){
		this.exchangeTime = exchangeTime;
	}
	
	public int getStatus(){
		return this.status;
	}
	
	public void setStatus(int status){
		this.status = status;
	}
	
	public String getTrackingCompany(){
		return this.trackingCompany;
	}
	
	public void setTrackingCompany(String trackingCompany){
		this.trackingCompany = trackingCompany;
	}
	
	public String getTrackingNo(){
		return this.trackingNo;
	}
	
	public void setTrackingNo(String trackingNo){
		this.trackingNo = trackingNo;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getReceivor() {
		return receivor;
	}

	public void setReceivor(String receivor) {
		this.receivor = receivor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
