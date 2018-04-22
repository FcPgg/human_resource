package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_seller_recharge_trade_log")
public class MtSellerRechargeTradeLog extends BaseEntity {
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int SellerId;
	
	@Column(name = "amount", columnDefinition = "double")
	private double Amount;
	
	@Column(name = "recharge_order_code", columnDefinition = "varchar(100)")
	private String RechargeOrderCode;
	
	@Column(name = "recharge_state", columnDefinition = "int(11)")
	private int RechargeState;
	
	@Column(name = "creation_time", columnDefinition = "datetime")
	private Date CreationTime;
	
	@Column(name="number",columnDefinition="int")
	private int number;
	
	@Column(name = "setMealId",columnDefinition="int")
	private int setMealId;
	
	
	public int getSellerId(){
		return this.SellerId;
	}
	
	public void setSellerId(int SellerId){
		this.SellerId = SellerId;
	}
	
	
	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getRechargeOrderCode(){
		return this.RechargeOrderCode;
	}
	
	public void setRechargeOrderCode(String RechargeOrderCode){
		this.RechargeOrderCode = RechargeOrderCode;
	}
	
	public int getRechargeState(){
		return this.RechargeState;
	}
	
	public void setRechargeState(int RechargeState){
		this.RechargeState = RechargeState;
	}
	
	public Date getCreationTime(){
		return this.CreationTime;
	}
	
	public void setCreationTime(Date CreationTime){
		this.CreationTime = CreationTime;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSetMealId() {
		return setMealId;
	}

	public void setSetMealId(int setMealId) {
		this.setMealId = setMealId;
	}
	
	
	
}
