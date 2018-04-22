package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_category")
public class MtCategory extends BaseEntity {
	
	@Column(name = "pid", columnDefinition = "int(11)")
	private int pid;
	
	@Column(name = "cat_name", columnDefinition = "varchar(100)", unique = true)
	private String catName;
	
	@Column(name = "sort_order", columnDefinition = "int(11)")
	private int sortOrder;
	
	@Column(name = "logo", columnDefinition = "varchar(200)")
	private String logo;
	
	/**
	 * 入驻费
	 */
	@Column(name = "settlement_fee", columnDefinition = "decimal(18,2)")
	private double settlementFee;
	
	@Formula("( select  concat_ws('.', s.uuid, s.src_file_type) from sys_attachments s where s.id = logo)")
	private String logoAttUrl;
	
	
	public String getLogoAttUrl() {
		return logoAttUrl;
	}

	public void setLogoAttUrl(String logoAttUrl) {
		this.logoAttUrl = logoAttUrl;
	}

	public int getPid(){
		return this.pid;
	}
	
	public void setPid(int pid){
		this.pid = pid;
	}
	
	public String getCatName(){
		return this.catName;
	}
	
	public void setCatName(String catName){
		this.catName = catName;
	}
	
	public int getSortOrder(){
		return this.sortOrder;
	}
	
	public void setSortOrder(int sortOrder){
		this.sortOrder = sortOrder;
	}
	
	public String getLogo(){
		return this.logo;
	}
	
	public void setLogo(String logo){
		this.logo = logo;
	}

	public double getSettlementFee() {
		return settlementFee;
	}

	public void setSettlementFee(double settlementFee) {
		this.settlementFee = settlementFee;
	}
}
