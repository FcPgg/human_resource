package com.xt.ptus.mt.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_groups")
public class MtUserGroups extends BaseEntity {
	
	@Column(name = "group_name", columnDefinition = "varchar(100)")
	private String groupName;
	
	@Column(name = "group_info", columnDefinition = "varchar(200)")
	private String groupInfo;
	
	@Column(name = "master_id", columnDefinition = "int(11)")
	private int masterId;
	
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	@Formula("(select a.user_name from mt_user_info a where a.id = master_id)")
	private String masterName;
	
	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	/**
	 * 权限
	 * @return
	 */
	@Transient
	private List<MtUserGroupMapping> groupPermission;

	public List<MtUserGroupMapping> getGroupPermission() {
		return groupPermission;
	}

	public void setGroupPermission(List<MtUserGroupMapping> groupPermission) {
		this.groupPermission = groupPermission;
	}

	public String getGroupName(){
		return this.groupName;
	}
	
	public void setGroupName(String groupName){
		this.groupName = groupName;
	}
	
	public String getGroupInfo(){
		return this.groupInfo;
	}
	
	public void setGroupInfo(String groupInfo){
		this.groupInfo = groupInfo;
	}
	
	public int getMasterId(){
		return this.masterId;
	}
	
	public void setMasterId(int masterId){
		this.masterId = masterId;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")  
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
