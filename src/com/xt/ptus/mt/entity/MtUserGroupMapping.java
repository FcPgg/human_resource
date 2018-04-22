package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_group_mapping")
public class MtUserGroupMapping extends BaseEntity {
	
	@Column(name = "group_id", columnDefinition = "int(11)")
	private int groupId;
	
	@Column(name = "permission_id", columnDefinition = "int(11)")
	private int permissionId;
	
	@Column(name = "master_id", columnDefinition = "int(11)")
	private int masterId;
	
	@Column(name = "create_time", columnDefinition = "dateTime")
	private Date createTime;
	
	
	
	public int getGroupId(){
		return this.groupId;
	}
	
	public void setGroupId(int groupId){
		this.groupId = groupId;
	}
	
	public int getPermissionId(){
		return this.permissionId;
	}
	
	public void setPermissionId(int permissionId){
		this.permissionId = permissionId;
	}
	
	public int getMasterId(){
		return this.masterId;
	}
	
	public void setMasterId(int masterId){
		this.masterId = masterId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
