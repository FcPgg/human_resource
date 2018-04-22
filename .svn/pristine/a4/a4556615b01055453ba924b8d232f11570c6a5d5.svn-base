package com.xt.ptus.mt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_seller_gallery")
public class MtSellerGallery extends BaseEntity {
	
	@Column(name = "att_id", columnDefinition = "int(11)")
	private int attId;
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int sellerId;
	
	@Column(name="sort",columnDefinition="int(11)")
	private String sort;

	@Formula("(select t.access_url from mt_material_resources t where t.id = att_id)")
	private String resourceAccessUrl;

	public String getResourceAccessUrl() {
		return resourceAccessUrl;
	}

	public void setResourceAccessUrl(String resourceAccessUrl) {
		this.resourceAccessUrl = resourceAccessUrl;
	}

	public int getAttId(){
		return this.attId;
	}
	
	public void setAttId(int attId){
		this.attId = attId;
	}
	

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	
	
}
