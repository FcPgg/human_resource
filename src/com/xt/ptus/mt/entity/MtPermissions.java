package com.xt.ptus.mt.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xt.ptus.base.BaseEntity;
import com.xt.ptus.sys.entity.SysMenus;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_permissions")
public class MtPermissions extends BaseEntity {
	
	
	@Column(name = "action_name", columnDefinition = "varchar(50)")
	private String actionName;
	
	@Column(name = "action", columnDefinition = "varchar(100)")
	private String action;
	
	@Column(name = "pid",columnDefinition="int")
	private int pid;
	
	
	@Transient
	private List<MtPermissions> children = new ArrayList<MtPermissions>();
	
	public List<MtPermissions> getChildren() {
		return children;
	}

	public void setChildren(List<MtPermissions> children) {
		this.children = children;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getActionName(){
		return this.actionName;
	}
	
	public void setActionName(String actionName){
		this.actionName = actionName;
	}
	
	public String getAction(){
		return this.action;
	}
	
	public void setAction(String action){
		this.action = action;
	}
	
	
}
