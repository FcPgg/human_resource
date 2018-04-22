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
@Table(name = "mt_integrate_flow")
public class MtIntegrateFlow extends BaseEntity {
	
	@Column(name = "order_id", columnDefinition = "int(11)")
	private int OrderId;
	
	@Column(name = "order_goods_id", columnDefinition = "int(11)")
	private int OrderGoodsId;
	
	@Column(name = "credit_order_id", columnDefinition = "int(11)")
	private int CreditOrderId;
	
	@Column(name = "category", columnDefinition = "int(11)")
	private int Category;
	
	@Column(name = "source", columnDefinition = "varchar(1000)")
	private String Source;
	
	@Column(name = "target", columnDefinition = "varchar(1000)")
	private String Target;
	
	@Column(name = "amount", columnDefinition = "int(11)")
	private int Amount;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String Remark;
	
	@Column(name = "operator", columnDefinition = "int(11)")
	private int Operator;
	
	@Column(name = "operate_time", columnDefinition = "datetime")
	private Date OperateTime;
	
	@Column(name = "description", columnDefinition = "varchar(200)")
	private String Description;
	
	
	public int getOrderId(){
		return this.OrderId;
	}
	
	public void setOrderId(int OrderId){
		this.OrderId = OrderId;
	}
	
	public int getOrderGoodsId(){
		return this.OrderGoodsId;
	}
	
	public void setOrderGoodsId(int OrderGoodsId){
		this.OrderGoodsId = OrderGoodsId;
	}
	
	public int getCreditOrderId(){
		return this.CreditOrderId;
	}
	
	public void setCreditOrderId(int CreditOrderId){
		this.CreditOrderId = CreditOrderId;
	}
	
	public int getCategory(){
		return this.Category;
	}
	
	public void setCategory(int Category){
		this.Category = Category;
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
	
	public String getRemark(){
		return this.Remark;
	}
	
	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public void setRemark(String Remark){
		this.Remark = Remark;
	}
	
	public int getOperator(){
		return this.Operator;
	}
	
	public void setOperator(int Operator){
		this.Operator = Operator;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getOperateTime(){
		return this.OperateTime;
	}
	
	public void setOperateTime(Date OperateTime){
		this.OperateTime = OperateTime;
	}
	
	public String getDescription(){
		return this.Description;
	}
	
	public void setDescription(String Description){
		this.Description = Description;
	}
	
}
