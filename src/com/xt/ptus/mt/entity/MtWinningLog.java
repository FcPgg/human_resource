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
@Table(name = "mt_winning_log")
public class MtWinningLog extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "prizes_id", columnDefinition = "int(11)")
	private int prizesId;
	
	@Column(name = "prizes_title", columnDefinition = "varchar(200)")
	private String prizesTitle;
	
	@Column(name = "winning_time", columnDefinition = "datetime")
	private Date winningTime;
	
	@Column(name = "if_exchange", columnDefinition = "char(1)")
	private String ifExchange;
	
	@Column(name = "exchange_time", columnDefinition = "datetime")
	private Date exchangeTime;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;
	
	@Column(name = "receivor", columnDefinition = "varchar(50)")
	private String receivor;
	
	@Column(name = "address", columnDefinition = "varchar(500)")
	private String address;
	
	@Column(name = "phone_number", columnDefinition = "varchar(20)")
	private String phoneNumber;
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getPrizesId(){
		return this.prizesId;
	}
	
	public void setPrizesId(int prizesId){
		this.prizesId = prizesId;
	}
	
	public String getPrizesTitle() {
		return prizesTitle;
	}

	public void setPrizesTitle(String prizesTitle) {
		this.prizesTitle = prizesTitle;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getWinningTime(){
		return this.winningTime;
	}
	
	public void setWinningTime(Date winningTime){
		this.winningTime = winningTime;
	}
	
	public String getIfExchange(){
		return this.ifExchange;
	}
	
	public void setIfExchange(String ifExchange){
		this.ifExchange = ifExchange;
	}
	
	public Date getExchangeTime(){
		return this.exchangeTime;
	}
	
	public void setExchangeTime(Date exchangeTime){
		this.exchangeTime = exchangeTime;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getReceivor() {
		return receivor;
	}

	public void setReceivor(String receivor) {
		this.receivor = receivor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
