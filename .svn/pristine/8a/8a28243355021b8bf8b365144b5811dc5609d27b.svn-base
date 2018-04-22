package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_order_operate_log")
public class MtOrderOperateLog extends BaseEntity {
	
	@Column(name = "order_id", columnDefinition = "int(11)")
	private int orderId;
	
	@Column(name = "operator", columnDefinition = "int(11)")
	private int operator;
	
	@Column(name = "category", columnDefinition = "int(11)")
	private int category;
	
	@Column(name = "operate_time", columnDefinition = "datetime")
	private Date operateTime;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;
	
	@Column(name="task_id",columnDefinition = "varchar(100)")
    private String taskId;
	

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public int getOrderId(){
		return this.orderId;
	}
	
	public void setOrderId(int orderId){
		this.orderId = orderId;
	}
	
	public int getOperator(){
		return this.operator;
	}
	
	public void setOperator(int operator){
		this.operator = operator;
	}
	
	public int getCategory(){
		return this.category;
	}
	
	public void setCategory(int category){
		this.category = category;
	}
	
	public Date getOperateTime(){
		return this.operateTime;
	}
	
	public void setOperateTime(Date operateTime){
		this.operateTime = operateTime;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
}
