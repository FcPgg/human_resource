package com.xt.ptus.mt.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_system_advertisement")
public class MtSystemAdvertisement extends BaseEntity {
	
	
	@Column(name = "ad_name", columnDefinition = "varchar(100)")
	private String adName;
	
	@Column(name = "att_id", columnDefinition = "int(11)")
	private int attId;
	
	@Formula("( select  concat_ws('.', s.uuid, s.src_file_type) from sys_attachments s where s.id = att_id)")
	private String logoAttUrl;
	
	@Column(name="symptom",columnDefinition = "varchar(200)")
	private String symptom;
	
	@Column(name="programme",columnDefinition = "varchar(1000)")
	private String programme;
	
	@Column(name="category",columnDefinition = "int(5)")
    private int category;
	
	@Formula(value="(select a.cat_name from mt_category a where a.id = category)")
	private String catName;
	
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	
	public String getLogoAttUrl() {
		return logoAttUrl;
	}

	public void setLogoAttUrl(String logoAttUrl) {
		this.logoAttUrl = logoAttUrl;
	}

	public String getAdName(){
		return this.adName;
	}
	
	public void setAdName(String adName){
		this.adName = adName;
	}
	
	
	public int getAttId() {
		return attId;
	}

	public void setAttId(int attId) {
		this.attId = attId;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
    
	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}


	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	
	
}
