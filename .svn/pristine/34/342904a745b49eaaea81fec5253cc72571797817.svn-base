package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_read_log")
public class MtUserReadLog extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "info_id", columnDefinition = "int(11)")
	private int infoId;
	
	@Column(name = "read_time", columnDefinition = "datetime")
	private Date readTime;
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getInfoId(){
		return this.infoId;
	}
	
	public void setInfoId(int infoId){
		this.infoId = infoId;
	}
	
	public Date getReadTime(){
		return this.readTime;
	}
	
	public void setReadTime(Date readTime){
		this.readTime = readTime;
	}
	
}
