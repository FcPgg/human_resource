package com.xt.ptus.mt.entity;

import java.util.Date;

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
@Table(name = "mt_user_browse_log")
public class MtUserBrowseLog extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int sellerId;
	
	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;
	
	@Column(name = "browse_time", columnDefinition = "datetime")
	private Date browseTime;
	
	@Transient
	private double minPrice;
	
	@Transient
	private double maxPrice;
	
	
	
	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Formula("(select a.name from mt_goods a where a.id = goods_id)")
	private String goodsName;
	
	@Formula("(select a.name from mt_seller a where a.id = seller_id)")
	private String sellerName;
	
	@Formula("(select a.business_scope from mt_seller a where a.id = seller_id)")
	private String businessScope;
	
	//商品展示图
	@Formula("(select r.access_url from mt_material_resources r where r.id = (select g.resource_id from mt_goods_gallery g where g.goods_id = goods_id and g.sort = 0))")
	private String indexResourceAccessUrl;
	
	//商家展示图
	@Formula(value="(select a.access_url from mt_material_resources a where a.id in (select b.att_id from mt_seller_gallery b where b.seller_id = seller_id and b.sort=0))")
	private String sellerExhibitionUrl;
	
	public String getSellerExhibitionUrl() {
		return sellerExhibitionUrl;
	}

	public void setSellerExhibitionUrl(String sellerExhibitionUrl) {
		this.sellerExhibitionUrl = sellerExhibitionUrl;
	}

	public String getIndexResourceAccessUrl() {
		return indexResourceAccessUrl;
	}

	public void setIndexResourceAccessUrl(String indexResourceAccessUrl) {
		this.indexResourceAccessUrl = indexResourceAccessUrl;
	}

	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public int getSellerId(){
		return this.sellerId;
	}
	
	public void setSellerId(int sellerId){
		this.sellerId = sellerId;
	}
	
	public int getGoodsId(){
		return this.goodsId;
	}
	
	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	public Date getBrowseTime(){
		return this.browseTime;
	}
	
	public void setBrowseTime(Date browseTime){
		this.browseTime = browseTime;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
}
