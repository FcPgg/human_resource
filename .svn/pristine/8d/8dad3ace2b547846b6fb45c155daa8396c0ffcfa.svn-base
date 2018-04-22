package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_common_attachements")
public class MtCommonAttachements extends BaseEntity {
	
	
	@Column(name = "src_name", columnDefinition = "varchar(500)")
	private String srcName;
	
	@Column(name = "src_file_type", columnDefinition = "varchar(20)")
	private String srcFileType;
	
	@Column(name = "file_name", columnDefinition = "varchar(100)")
	private String fileName;
	
	@Column(name = "uuid", columnDefinition = "varchar(100)")
	private String uuid;
	
	 
	
	public String getSrcName(){
		return this.srcName;
	}
	
	public void setSrcName(String srcName){
		this.srcName = srcName;
	}
	
	public String getSrcFileType(){
		return this.srcFileType;
	}
	
	public void setSrcFileType(String srcFileType){
		this.srcFileType = srcFileType;
	}
	
	public String getFileName(){
		return this.fileName;
	}
	
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public String getUuid(){
		return this.uuid;
	}
	
	public void setUuid(String uuid){
		this.uuid = uuid;
	}
	
}
