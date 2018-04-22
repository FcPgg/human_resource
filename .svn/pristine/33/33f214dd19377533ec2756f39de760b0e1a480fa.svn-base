package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_account_trade_log")
public class MtUserAccountTradeLog extends BaseEntity {
	
	/**
	 * 用户编号
	 */
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	/**
	 * 分类
	 * 0:用户支付订单
	 * 1:用户提现
	 * 2:退款流入
	 * 3:用户充值余额
	 */
	@Column(name = "category", columnDefinition = "int(11)")
	private int category;
	
	/**
	 * 金额
	 */
	@Column(name = "amount", columnDefinition = "decimal(18,2)")
	private double amount;
	
	/**
	 * 来源
	 */
	@Column(name = "source", columnDefinition = "varchar(200)")
	private String source;
	
	/**
	 * 去向
	 */
	@Column(name = "target", columnDefinition = "varchar(200)")
	private String target;
	
	/**
	 * 交易时间
	 */
	@Column(name = "trade_time", columnDefinition = "datetime")
	private Date tradeTime;
	
	/**
	 * 操作人
	 */
	@Column(name = "operator", columnDefinition = "int(11)")
	private int operator;
	
	/**
	 * 备注
	 */
	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String remark;

	@Transient
	private String tradeTimeFormat;
	
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public double getAmount(){
		return this.amount;
	}
	
	public void setAmount(double amount){
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

	public String getTradeTimeFormat() {
		return tradeTimeFormat;
	}

	public void setTradeTimeFormat(String tradeTimeFormat) {
		this.tradeTimeFormat = tradeTimeFormat;
	}
}
