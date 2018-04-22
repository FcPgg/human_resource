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
@Table(name = "mt_panic_buying")
public class MtPanicBuying extends BaseEntity {

	
	@Column(name = "name", columnDefinition = "varchar(100)")
	private String name;
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int sellerId;
	
	/*
	 * 商家名称
	 */
	@Formula(value="(select a.name from mt_seller a where a.id = seller_id)")
	private String sellerName;

	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;
	
	/*
	 * 商品名称
	 */
	@Formula(value="(select a.name from mt_goods a where a.id = goods_id)")
	private String goodsName;
	
	@Formula("(select r.access_url from mt_material_resources r where r.id = (select g.resource_id from mt_goods_gallery g where g.goods_id = goods_id and g.sort = 0))")
	private String coverPhoto;
	
	@Column(name = "concessional_rate", columnDefinition = "double")
	private double concessionalRate;
	
	@Column(name = "startTime", columnDefinition = "datetime")
	private Date startTime;
	
	@Column(name = "endTime", columnDefinition = "datetime")
	private Date endTime;
	
	@Column(name = "creator_id", columnDefinition = "int(11)")
	private int creatorId;

	@Formula(value="(select a.nick_name from mt_user_info a where a.id = creator_id)")
	private String creator;
	
    /**
     * 商品价格
     * @return
     */
	
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

	public String getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public int getLimitNumber() {
		return limitNumber;
	}

	public void setLimitNumber(int limitNumber) {
		this.limitNumber = limitNumber;
	}

	public int getAlreadyPurchaseNumber() {
		return alreadyPurchaseNumber;
	}

	public void setAlreadyPurchaseNumber(int alreadyPurchaseNumber) {
		this.alreadyPurchaseNumber = alreadyPurchaseNumber;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	@Column(name = "number",columnDefinition = "int(11)")
	private int number;
	
	@Column(name="update_time",columnDefinition = "datetime")
	private Date  updateTime;
	
	@Column(name="updator",columnDefinition = "int(11)")
	private int updator;
	
    @Column(name="limit_number",columnDefinition = "int(11)")
    private int limitNumber;
    
    @Column(name = "already_purchase_number" , columnDefinition = "int(11)")
    private int alreadyPurchaseNumber;
    
    
    
		
	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getUpdator() {
		return updator;
	}

	public void setUpdator(int updator) {
		this.updator = updator;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
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
	

	
	public double getConcessionalRate() {
		return concessionalRate;
	}

	public void setConcessionalRate(double concessionalRate) {
		this.concessionalRate = concessionalRate;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getStartTime(){
		return this.startTime;
	}
	
	public void setStartTime(Date startTime){
		this.startTime = startTime;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getEndTime(){
		return this.endTime;
	}
	
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	
	public int getCreatorId(){
		return this.creatorId;
	}
	
	public void setCreatorId(int creatorId){
		this.creatorId = creatorId;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
}
