package com.xt.ptus.mt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_material_catalog")
public class MtMaterialCatalog extends BaseEntity {
	
	@Column(name = "pid", columnDefinition = "int(11)")
	private int pid;
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int sellerId;
	
	@Column(name = "name", columnDefinition = "varchar(100)")
	private String name;
	
	@Transient
	private List<MtMaterialCatalog> children;
	
	
	public int getPid(){
		return this.pid;
	}
	
	public void setPid(int pid){
		this.pid = pid;
	}
	
	public int getSellerId(){
		return this.sellerId;
	}
	
	public void setSellerId(int sellerId){
		this.sellerId = sellerId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public List<MtMaterialCatalog> getChildren() {
		return children;
	}

	public void setChildren(List<MtMaterialCatalog> children) {
		this.children = children;
	}
}
