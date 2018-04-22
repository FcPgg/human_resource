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
@Table(name = "mt_platform_capital_trade_log")
public class MtPlatformCapitalTradeLog extends BaseEntity {
	
	@Column(name = "source", columnDefinition = "varchar(200)")
	private String source;
	
	@Column(name = "target", columnDefinition = "varchar(200)")
	private String target;
	
	@Column(name = "amount", columnDefinition = "decimal(18,2)")
	private double amount;
	
	@Column(name = "trade_time", columnDefinition = "datetime")
	private Date tradeTime;
	
	@Column(name = "operator", columnDefinition = "int(11)")
	private int operator;
	
	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String remark;
	
	@Column(name = "user_money_flow_id", columnDefinition = "int(11)")
	private int userMoneyFlowId;
	
	@Column(name = "credit_order_id", columnDefinition = "int(11)")
	private int creditOrderId;
	
	@Column(name = "pay_to_seller_id", columnDefinition = "int(11)")
	private int payToSellerId;
	
	@Column(name = "seller_withdrawals_id", columnDefinition = "int(11)")
	private int sellerWithdrawalsId;
	
	@Column(name = "user_withdrawals_id", columnDefinition = "int(11)")
	private int userWithdrawalsId;
	
	@Column(name = "user_recharge_id", columnDefinition = "int(11)")
	private int userRechargeId;
	
	@Column(name = "seller_buy_integrate_id", columnDefinition = "int(11)")
	private int sellerBuyIntegrateId;
	
	@Column(name = "user_buy_integrate_id", columnDefinition = "int(11)")
	private int userBuyIntegrateId;
	
	
	@Column(name = "sort",columnDefinition = "int(11)")
	private int sort;
	
	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
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
	
	public double getAmount(){
		return this.amount;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
	
	public int getUserMoneyFlowId(){
		return this.userMoneyFlowId;
	}
	
	public void setUserMoneyFlowId(int userMoneyFlowId){
		this.userMoneyFlowId = userMoneyFlowId;
	}
	
	public int getCreditOrderId(){
		return this.creditOrderId;
	}
	
	public void setCreditOrderId(int creditOrderId){
		this.creditOrderId = creditOrderId;
	}
	
	public int getPayToSellerId(){
		return this.payToSellerId;
	}
	
	public void setPayToSellerId(int payToSellerId){
		this.payToSellerId = payToSellerId;
	}
	
	public int getSellerWithdrawalsId(){
		return this.sellerWithdrawalsId;
	}
	
	public void setSellerWithdrawalsId(int sellerWithdrawalsId){
		this.sellerWithdrawalsId = sellerWithdrawalsId;
	}
	
	public int getUserWithdrawalsId(){
		return this.userWithdrawalsId;
	}
	
	public void setUserWithdrawalsId(int userWithdrawalsId){
		this.userWithdrawalsId = userWithdrawalsId;
	}
	
	public int getUserRechargeId(){
		return this.userRechargeId;
	}
	
	public void setUserRechargeId(int userRechargeId){
		this.userRechargeId = userRechargeId;
	}
	
	public int getSellerBuyIntegrateId(){
		return this.sellerBuyIntegrateId;
	}
	
	public void setSellerBuyIntegrateId(int sellerBuyIntegrateId){
		this.sellerBuyIntegrateId = sellerBuyIntegrateId;
	}
	
	public int getUserBuyIntegrateId(){
		return this.userBuyIntegrateId;
	}
	
	public void setUserBuyIntegrateId(int userBuyIntegrateId){
		this.userBuyIntegrateId = userBuyIntegrateId;
	}
	
}
