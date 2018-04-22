package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_material_resources")
public class MtMaterialResources extends BaseEntity {
	
	@Column(name = "catalog_id", columnDefinition = "int(11)")
	private int catalogId;
	
	@Column(name = "src_file_name", columnDefinition = "varchar(1000)")
	private String srcFileName;
	
	@Column(name = "src_file_type", columnDefinition = "varchar(1000)")
	private String srcFileType;
	
	@Column(name = "new_file_name", columnDefinition = "varchar(100)")
	private String newFileName;
	
	@Column(name = "new_file_type", columnDefinition = "varchar(10)")
	private String newFileType;
	
	@Column(name = "upload_time", columnDefinition = "datetime")
	private Date uploadTime;
	
	@Column(name = "uploador", columnDefinition = "int(11)")
	private int uploador;
	
	@Column(name = "access_url", columnDefinition = "varchar(2000)")
	private String accessUrl;
	
	public int getCatalogId(){
		return this.catalogId;
	}
	
	public void setCatalogId(int catalogId){
		this.catalogId = catalogId;
	}
	
	public String getSrcFileName(){
		return this.srcFileName;
	}
	
	public void setSrcFileName(String srcFileName){
		this.srcFileName = srcFileName;
	}
	
	public String getSrcFileType(){
		return this.srcFileType;
	}
	
	public void setSrcFileType(String srcFileType){
		this.srcFileType = srcFileType;
	}
	
	public String getNewFileName(){
		return this.newFileName;
	}
	
	public void setNewFileName(String newFileName){
		this.newFileName = newFileName;
	}
	
	public String getNewFileType(){
		return this.newFileType;
	}
	
	public void setNewFileType(String newFileType){
		this.newFileType = newFileType;
	}
	
	public Date getUploadTime(){
		return this.uploadTime;
	}
	
	public void setUploadTime(Date uploadTime){
		this.uploadTime = uploadTime;
	}
	
	public int getUploador(){
		return this.uploador;
	}
	
	public void setUploador(int uploador){
		this.uploador = uploador;
	}

	public String getAccessUrl() {
		return accessUrl;
	}

	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}
}
