package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_choice_group")
public class MtChoiceGroup extends BaseEntity {
	
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "group_id", columnDefinition = "int(11)")
	private int groupId;
	
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getGroupId(){
		return this.groupId;
	}
	
	public void setGroupId(int groupId){
		this.groupId = groupId;
	}
	
}
