package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_money_flow")
public class MtMoneyFlow extends BaseEntity {
	
	@Column(name = "order_id", columnDefinition = "int(11)")
	private int orderId;
	
	@Column(name = "order_goods_id", columnDefinition = "int(11)")
	private int orderGoodsId;
	
	@Column(name = "credit_order_id", columnDefinition = "int(11)")
	private int creditOrderId;
	
	@Column(name = "category", columnDefinition = "int(11)")
	private int category;
	
	@Column(name = "source", columnDefinition = "varchar(1000)")
	private String source;
	
	@Column(name = "froms", columnDefinition = "varchar(1000)")
	private String froms;
	
	@Column(name = "amount", columnDefinition = "double")
	private double amount;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;
	
	@Column(name = "operator", columnDefinition = "int(11)")
	private int operator;
	
	@Column(name = "operate_time", columnDefinition = "datetime")
	private Date operateTime;
	
	@Column(name = "description", columnDefinition = "varchar(200)")
	private String description;
	
	
	
	public int getOrderId(){
		return this.orderId;
	}
	
	public void setOrderId(int orderId){
		this.orderId = orderId;
	}
	
	public int getOrderGoodsId(){
		return this.orderGoodsId;
	}
	
	public void setOrderGoodsId(int orderGoodsId){
		this.orderGoodsId = orderGoodsId;
	}
	
	public int getCreditOrderId(){
		return this.creditOrderId;
	}
	
	public void setCreditOrderId(int creditOrderId){
		this.creditOrderId = creditOrderId;
	}
	
	public int getCategory(){
		return this.category;
	}
	
	public void setCategory(int category){
		this.category = category;
	}
	
	public String getSource(){
		return this.source;
	}
	
	public void setSource(String source){
		this.source = source;
	}
	
	public String getFroms(){
		return this.froms;
	}
	
	public void setFroms(String froms){
		this.froms = froms;
	}
	
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public int getOperator(){
		return this.operator;
	}
	
	public void setOperator(int operator){
		this.operator = operator;
	}
	
	public Date getOperateTime(){
		return this.operateTime;
	}
	
	public void setOperateTime(Date operateTime){
		this.operateTime = operateTime;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
}
