package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_task_exe_log")
public class MtTaskExeLog extends BaseEntity {
	
	@Column(name = "task_id", columnDefinition = "int(11)")
	private int taskId;
	
	@Column(name = "chanel", columnDefinition = "varchar(20)")
	private String chanel;
	
	@Column(name = "execute_time", columnDefinition = "varchar(20)")
	private String executeTime;
	
	@Column(name = "execute_count", columnDefinition = "int(11)")
	private int executeCount;
	
	@Column(name = "executed_result", columnDefinition = "char(1)")
	private String executedResult;
	
	@Column(name = "error_reason", columnDefinition = "varchar(4000)")
	private String errorReason;
	
	@Column(name = "service_name", columnDefinition = "varchar(50)")
	private String serviceName;
	
	@Column(name = "method_name", columnDefinition = "varchar(100)")
	private String methodName;
	
	@Column(name = "params", columnDefinition = "varchar(1000)")
	private String params;
	
	@Column(name = "remark", columnDefinition = "varchar(2000)")
	private String remark;
	
	@Column(name = "run_time", columnDefinition = "datetime")
	private Date runTime;
	
	public int getTaskId(){
		return this.taskId;
	}
	
	public void setTaskId(int taskId){
		this.taskId = taskId;
	}
	
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
	
	public int getExecuteCount(){
		return this.executeCount;
	}
	
	public void setExecuteCount(int executeCount){
		this.executeCount = executeCount;
	}
	
	public String getExecutedResult(){
		return this.executedResult;
	}
	
	public void setExecutedResult(String executedResult){
		this.executedResult = executedResult;
	}
	
	public String getErrorReason(){
		return this.errorReason;
	}
	
	public void setErrorReason(String errorReason){
		this.errorReason = errorReason;
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
	
	public String getParams(){
		return this.params;
	}
	
	public void setParams(String params){
		this.params = params;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}

	public Date getRunTime() {
		return runTime;
	}

	public void setRunTime(Date runTime) {
		this.runTime = runTime;
	}
}
