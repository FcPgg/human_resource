package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_seller_account_trade_log")
public class MtSellerAccountTradeLog extends BaseEntity {
	
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int sellerId;
	
	@Column(name = "amount", columnDefinition = "decimal(18,2)")
	private double amount;
	
	@Column(name = "source", columnDefinition = "varchar(200)")
	private String source;
	
	@Column(name = "target", columnDefinition = "varchar(200)")
	private String target;
	
	@Column(name = "trade_time", columnDefinition = "datetime")
	private Date tradeTime;
	
	@Column(name = "operator", columnDefinition = "int(11)")
	private int operator;
	
	@Formula("(select a.nick_name from mt_user_info a where a.id = operator)")
	private String operatorName;
	
	
	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String remark;
	


	public int getSellerId(){
		return this.sellerId;
	}
	
	public void setSellerId(int sellerId){
		this.sellerId = sellerId;
	}
	
    
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSource(){
		return this.source;
	}
	
	public void setSource(String source){
		this.source = source;
	}
	
	public String getTarget(){
		return this.target;
	}
	
	public void setTarget(String target){
		this.target = target;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getTradeTime(){
		return this.tradeTime;
	}
	
	public void setTradeTime(Date tradeTime){
		this.tradeTime = tradeTime;
	}
	
	public int getOperator(){
		return this.operator;
	}
	
	public void setOperator(int operator){
		this.operator = operator;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
}
