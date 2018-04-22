package com.xt.ptus.mt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_task_list")
public class MtTaskList extends BaseEntity {
	
	@Column(name = "chanel", columnDefinition = "varchar(20)")
	private String chanel;
	
	/**
	 * 执行时间 yyyy-MM-dd HH:mm:ss
	 */
	@Column(name = "execute_time", columnDefinition = "varchar(20)")
	private String executeTime;
	
	@Column(name = "service_name", columnDefinition = "varchar(50)")
	private String serviceName;
	
	@Column(name = "method_name", columnDefinition = "varchar(100)")
	private String methodName;
	
	@Column(name = "remark", columnDefinition = "varchar(2000)")
	private String remark;

	@Transient
	private List<MtTaskParams> params;
	
	public String getChanel(){
		return this.chanel;
	}
	
	public void setChanel(String chanel){
		this.chanel = chanel;
	}
	
	public String getExecuteTime(){
		return this.executeTime;
	}
	
	public void setExecuteTime(String executeTime){
		this.executeTime = executeTime;
	}
	
	public String getServiceName(){
		return this.serviceName;
	}
	
	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}
	
	public String getMethodName(){
		return this.methodName;
	}
	
	public void setMethodName(String methodName){
		this.methodName = methodName;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}

	public List<MtTaskParams> getParams() {
		return params;
	}

	public void setParams(List<MtTaskParams> params) {
		this.params = params;
	}
}
