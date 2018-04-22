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
@Table(name = "mt_sign_in")
public class MtSignIn extends BaseEntity {
	
	@Column(name = "day_no", columnDefinition = "varchar(10)")
	private String dayNo;
	
	@Formula(value = "( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'dayNoDictionary') and b.code = day_no )")
	private String dayNoFormat;
	
	@Column(name = "title", columnDefinition = "varchar(50)")
	private String title;
	
	@Column(name = "count", columnDefinition = "int(11)")
	private int count;
	
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String remark;

	public String getDayNo() {
		return dayNo;
	}

	public void setDayNo(String dayNo) {
		this.dayNo = dayNo;
	}

	public String getDayNoFormat() {
		return dayNoFormat;
	}

	public void setDayNoFormat(String dayNoFormat) {
		this.dayNoFormat = dayNoFormat;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCount(){
		return this.count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
}
