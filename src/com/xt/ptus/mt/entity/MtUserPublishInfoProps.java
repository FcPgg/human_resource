package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_publish_info_props")
public class MtUserPublishInfoProps extends BaseEntity {
	
	
	@Column(name = "info_id", columnDefinition = "int(11)")
	private int infoId;
	
	@Column(name = "temp_id", columnDefinition = "int(11)")
	private int tempId;
	
	@Column(name = "code", columnDefinition = "varchar(100)")
	private String code;
	
	@Column(name = "value", columnDefinition = "varchar(500)")
	private String value;
	
	@Column(name = "control_type", columnDefinition = "varchar(100)")
	private String controlType;
	
	public int getInfoId(){
		return this.infoId;
	}
	
	public void setInfoId(int infoId){
		this.infoId = infoId;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public void setValue(String value){
		this.value = value;
	}

	public int getTempId() {
		return tempId;
	}

	public void setTempId(int tempId) {
		this.tempId = tempId;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}
}
