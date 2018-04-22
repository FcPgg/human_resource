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
@Table(name = "mt_seller_voucher_center")
public class MtSellerVoucherCenter extends BaseEntity {
	
	@Column(name = "e_coin_number", columnDefinition = "int(11)")
	private int ECoinNumber;
	
	@Column(name = "recharge_price", columnDefinition = "double")
	private double  RechargePrice;
	
	@Column(name = "creates", columnDefinition = "int(11)")
	private int Creates;
	
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date CreateTime;
	
	
	public int getECoinNumber(){
		return this.ECoinNumber;
	}
	
	public void setECoinNumber(int ECoinNumber){
		this.ECoinNumber = ECoinNumber;
	}
	
	
	public double getRechargePrice() {
		return RechargePrice;
	}

	public void setRechargePrice(double rechargePrice) {
		RechargePrice = rechargePrice;
	}

	public int getCreates(){
		return this.Creates;
	}
	
	public void setCreates(int Creates){
		this.Creates = Creates;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime(){
		return this.CreateTime;
	}
	
	public void setCreateTime(Date CreateTime){
		this.CreateTime = CreateTime;
	}
	
}
