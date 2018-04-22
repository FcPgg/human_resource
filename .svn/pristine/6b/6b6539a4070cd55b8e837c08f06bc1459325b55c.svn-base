package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_goods_gallery")
public class MtGoodsGallery extends BaseEntity {
	
	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;
	
	@Column(name = "resource_id", columnDefinition = "int(11)")
	private int resourceId;
	
	@Column(name = "sort", columnDefinition = "int(11)")
	private int sort;
	
	@Formula("(select t.access_url from mt_material_resources t where t.id = resource_id)")
	private String resourceAccessUrl;
	
	public int getGoodsId(){
		return this.goodsId;
	}
	
	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}
	
	public int getResourceId(){
		return this.resourceId;
	}
	
	public void setResourceId(int resourceId){
		this.resourceId = resourceId;
	}
	
	public int getSort(){
		return this.sort;
	}
	
	public void setSort(int sort){
		this.sort = sort;
	}

	public String getResourceAccessUrl() {
		return resourceAccessUrl;
	}

	public void setResourceAccessUrl(String resourceAccessUrl) {
		this.resourceAccessUrl = resourceAccessUrl;
	}
}
