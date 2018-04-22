package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_publish_info_atts")
public class MtUserPublishInfoAtts extends BaseEntity {
	
	@Column(name = "info_id", columnDefinition = "int(11)")
	private int infoId;
	
	@Column(name = "att_id", columnDefinition = "int(11)")
	private int attId;
	
	@Formula("( select concat_ws('.',s.uuid,s.src_file_type) from sys_attachments s where s.id = att_id)")
	private String attUrl;
	
	public int getInfoId(){
		return this.infoId;
	}
	
	public void setInfoId(int infoId){
		this.infoId = infoId;
	}
	
	public int getAttId(){
		return this.attId;
	}
	
	public void setAttId(int attId){
		this.attId = attId;
	}

	public String getAttUrl() {
		return attUrl;
	}

	public void setAttUrl(String attUrl) {
		this.attUrl = attUrl;
	}
}
