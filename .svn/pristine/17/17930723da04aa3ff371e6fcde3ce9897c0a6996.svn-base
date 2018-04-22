package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_goods_valuation_reply")
public class MtGoodsValuationReply extends BaseEntity {
	
	
	@Column(name = "valuation_id", columnDefinition = "int(11)")
	private int valuationId;
	
	@Column(name = "replier", columnDefinition = "int(11)")
	private int replier;
	
	@Column(name = "contents", columnDefinition = "varchar(500)")
	private String contents;
	
	@Column(name = "reply_time", columnDefinition = "datetime")
	private Date replyTime;
	
	
	
	public int getValuationId(){
		return this.valuationId;
	}
	
	public void setValuationId(int valuationId){
		this.valuationId = valuationId;
	}
	
	public int getReplier(){
		return this.replier;
	}
	
	public void setReplier(int replier){
		this.replier = replier;
	}
	
	public String getContents(){
		return this.contents;
	}
	
	public void setContents(String contents){
		this.contents = contents;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  
	public Date getReplyTime(){
		return this.replyTime;
	}
	
	public void setReplyTime(Date replyTime){
		this.replyTime = replyTime;
	}
	
}
