package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_seller_amount")
public class MtSellerAmount extends BaseEntity {
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int SellerId;
	
	@Column(name = "amount", columnDefinition = "decimal(18,2)")
	private double Amount;
	
	@Column(name = "source", columnDefinition = "varchar(200)")
	private String Source;
	
	@Column(name = "target", columnDefinition = "varchar(200)")
	private String Target;
	
	@Column(name = "trade_time", columnDefinition = "datetime")
	private Date TradeTime;
	
	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String Remark;
	
	
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

	public String getSource(){
		return this.Source;
	}
	
	public void setSource(String Source){
		this.Source = Source;
	}
	
	public String getTarget(){
		return this.Target;
	}
	
	public void setTarget(String Target){
		this.Target = Target;
	}
	
	public Date getTradeTime(){
		return this.TradeTime;
	}
	
	public void setTradeTime(Date TradeTime){
		this.TradeTime = TradeTime;
	}
	
	public String getRemark(){
		return this.Remark;
	}
	
	public void setRemark(String Remark){
		this.Remark = Remark;
	}
	
}
