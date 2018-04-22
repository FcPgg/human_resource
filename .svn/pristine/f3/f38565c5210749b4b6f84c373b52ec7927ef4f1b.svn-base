package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_task_params")
public class MtTaskParams extends BaseEntity {
	
	@Column(name = "task_id", columnDefinition = "int(11)")
	private int taskId;
	
	@Column(name = "name", columnDefinition = "varchar(100)")
	private String name;
	
	@Column(name = "param_name", columnDefinition = "varchar(100)")
	private String paramName;
	
	@Column(name = "data_type", columnDefinition = "varchar(100)")
	private String dataType;
	
	@Column(name = "value", columnDefinition = "varchar(100)")
	private String value;
	
	public int getTaskId(){
		return this.taskId;
	}
	
	public void setTaskId(int taskId){
		this.taskId = taskId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getParamName(){
		return this.paramName;
	}
	
	public void setParamName(String paramName){
		this.paramName = paramName;
	}
	
	public String getDataType(){
		return this.dataType;
	}
	
	public void setDataType(String dataType){
		this.dataType = dataType;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
}
