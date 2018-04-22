package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_search_log")
public class MtUserSearchLog extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "category", columnDefinition = "int(11)")
	private int category;
	
	@Column(name = "contents", columnDefinition = "varchar(100)")
	private String contents;
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getContents(){
		return this.contents;
	}
	
	public void setContents(String contents){
		this.contents = contents;
	}
	
}
