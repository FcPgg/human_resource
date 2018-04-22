package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_disease")
public class MtDisease extends BaseEntity {
	
	@Column(name = "address", columnDefinition = "varchar(255)")
	private String address;
	
	@Column(name = "categroy", columnDefinition = "int(10)")
	private int categroy;
	
	@Formula(value="(select a.cat_name from mt_category a where a.id = categroy)")
	private String catName;
	
	@Column(name = "symptom", columnDefinition = "varchar(255)")
	private String symptom;
	
	@Column(name = "season", columnDefinition = "varchar(20)")
	private String season;
	
	@Column(name = "describes", columnDefinition = "varchar(1000)")
	private String describe;
	
	@Column(name = "att_id", columnDefinition = "int(10)")
	private int attId;
	
	@Formula("( select  concat_ws('.', s.uuid, s.src_file_type) from sys_attachments s where s.id = att_id)")
	private String logoAttUrl;
	
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
//	@Column(name = "user_id", columnDefinition = "int(10)")
//	private int userId;
	
	@Column(name = "name", columnDefinition = "varchar(100)")
	private String name;
	
	@Column(name = "programme", columnDefinition = "varchar(1000)")
	private String programme;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCategroy() {
		return categroy;
	}

	public void setCategroy(int categroy) {
		this.categroy = categroy;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getAttId() {
		return attId;
	}

	public void setAttId(int attId) {
		this.attId = attId;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getLogoAttUrl() {
		return logoAttUrl;
	}

	public void setLogoAttUrl(String logoAttUrl) {
		this.logoAttUrl = logoAttUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	
	
	
	
}
