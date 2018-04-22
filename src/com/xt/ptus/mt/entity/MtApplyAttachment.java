package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_apply_attachment")
public class MtApplyAttachment extends BaseEntity {
	
	@Column(name = "apply_id", columnDefinition = "int(11)")
	private int applyId;
	
	@Column(name = "att_id", columnDefinition = "int(11)")
	private int attId;
	
	@Column(name = "category", columnDefinition = "int(11)")
	private int category;
	
	@Formula("(select t.file_name from mt_common_attachements t where t.id = att_id)")
	private String attachementsFile;
	
	@Formula("(select t.src_file_type from mt_common_attachements t where t.id = att_id)")
	private String fileType;
	
	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getAttachementsFile() {
		return attachementsFile;
	}

	public void setAttachementsFile(String attachementsFile) {
		this.attachementsFile = attachementsFile;
	}

	public int getApplyId(){
		return this.applyId;
	}
	
	public void setApplyId(int applyId){
		this.applyId = applyId;
	}
	
	public int getAttId(){
		return this.attId;
	}
	
	public void setAttId(int attId){
		this.attId = attId;
	}
	
	public int getCategory(){
		return this.category;
	}
	
	public void setCategory(int category){
		this.category = category;
	}
	
}
