package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_attention")
public class MtUserAttention extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "attention_id", columnDefinition = "int(11)")
	private int attentionId;
	
	@Column(name = "category", columnDefinition = "int(11)")
	private int category;
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getAttentionId(){
		return this.attentionId;
	}
	
	public void setAttentionId(int attentionId){
		this.attentionId = attentionId;
	}
	
	public int getCategory(){
		return this.category;
	}
	
	public void setCategory(int category){
		this.category = category;
	}
	
}
