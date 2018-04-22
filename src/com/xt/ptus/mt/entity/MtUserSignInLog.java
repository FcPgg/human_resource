package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_sign_in_log")
public class MtUserSignInLog extends BaseEntity {
	
	@Column(name = "sign_in_id", columnDefinition = "int(11)")
	private int signInId;
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "sign_in_time", columnDefinition = "datetime")
	private Date signInTime;
	
	@Transient
	private Date signInTimeFormat;
	
	@Column(name = "count", columnDefinition = "int(11)")
	private int count;
	
	public int getSignInId(){
		return this.signInId;
	}
	
	public void setSignInId(int signInId){
		this.signInId = signInId;
	}
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public Date getSignInTime(){
		return this.signInTime;
	}
	
	public void setSignInTime(Date signInTime){
		this.signInTime = signInTime;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getSignInTimeFormat() {
		return signInTime;
	}

	public void setSignInTimeFormat(Date signInTimeFormat) {
		this.signInTimeFormat = signInTimeFormat;
	}

	public int getCount(){
		return this.count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
}
