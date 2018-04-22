package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_account")
public class MtUserAccount extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "account_name", columnDefinition = "varchar(100)")
	private String accountName;
	
	/**
	 * wechat:微信账户
	 * alipay:支付宝账户
	 */
	@Column(name = "category", columnDefinition = "varchar(20)")
	private String category;
	
	/**
	 * 0:默认
	 * 1:非默认
	 */
	@Column(name = "if_default", columnDefinition = "char(1)")
	private String ifDefault;
	
	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String remark;
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public String getAccountName(){
		return this.accountName;
	}
	
	public void setAccountName(String accountName){
		this.accountName = accountName;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	public String getIfDefault(){
		return this.ifDefault;
	}
	
	public void setIfDefault(String ifDefault){
		this.ifDefault = ifDefault;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
}
