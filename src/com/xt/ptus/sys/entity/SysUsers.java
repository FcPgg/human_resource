package com.xt.ptus.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "sys_users")
public class SysUsers extends BaseEntity {
	
	/**
	 * 用户名
	 */
	@Column(name = "user_name", columnDefinition = "varchar(64)", unique = true)
	private String userName;
	
	/**
	 * 密码
	 */
	@Column(name = "password", columnDefinition = "varchar(64)")
	private String password;
	
	/**
	 * 状态
	 */
	@Column(name = "status", columnDefinition = "int")
	private int status;
	
	
	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String remark;
	
	@Column(name = "head_sculpture", columnDefinition = "varchar(200)")
	private String headSculpture;
	
	@Column(name = "is_admin", columnDefinition = "char(1)")
	private String isAdmin;
	
	@Column(name = "department", columnDefinition = "int")
	private int department;
	
	@Formula(value = "( select t.short_name from ams_organizations t where t.id = department )")
	private String departmentName;
	
	@Formula(value = "( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'userStatus') and b.code = cast(status as VARCHAR(10) ))")
	private String statusDesc;
	
	@Formula(value = "( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'ifDictionary') and b.code = is_admin)")
	private String isAdminDesc;
	
	@Formula(value = "( select t.name from ams_staff_info t where t.user_id = id )")
	private String staffName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getHeadSculpture() {
		return headSculpture;
	}

	public void setHeadSculpture(String headSculpture) {
		this.headSculpture = headSculpture;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getIsAdminDesc() {
		return isAdminDesc;
	}

	public void setIsAdminDesc(String isAdminDesc) {
		this.isAdminDesc = isAdminDesc;
	}
	
	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public boolean isAdmin(){
		return "0".equals(this.getIsAdmin());
	}
	
	public boolean hasDepartment(){
		return  this.getDepartment() > 0;
	}
}
