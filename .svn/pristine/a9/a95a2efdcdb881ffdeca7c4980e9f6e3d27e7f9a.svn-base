package com.xt.ptus.mt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xt.ptus.base.BaseEntity;
import com.xt.ptus.sys.entity.SysDictionaryDatas;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_publish_props_template")
public class MtUserPublishPropsTemplate extends BaseEntity {
	
	
	@Column(name = "info_id", columnDefinition = "int(11)")
	private int infoId;
	
	@Column(name = "code", columnDefinition = "varchar(100)")
	private String code;
	
	@Column(name = "control_type", columnDefinition = "varchar(20)")
	private String controlType;
	
	@Column(name = "dictionary", columnDefinition = "varchar(50)")
	private String dictionary;
	
	@Transient
	private List<SysDictionaryDatas> dict;
	
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
	
	public String getControlType(){
		return this.controlType;
	}
	
	public void setControlType(String controlType){
		this.controlType = controlType;
	}

	public String getDictionary() {
		return dictionary;
	}

	public void setDictionary(String dictionary) {
		this.dictionary = dictionary;
	}

	public List<SysDictionaryDatas> getDict() {
		return dict;
	}

	public void setDict(List<SysDictionaryDatas> dict) {
		this.dict = dict;
	}
}
