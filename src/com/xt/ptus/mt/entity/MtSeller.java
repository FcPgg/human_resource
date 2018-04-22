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
@Table(name = "mt_seller")
public class MtSeller extends BaseEntity {
	
	@Column(name = "seller_no", columnDefinition = "varchar(100)")
	private String sellerNo;

	@Column(name = "category_id", columnDefinition = "int(11)")
	private int categoryId;
	
	@Formula(value="(select a.cat_name from mt_category a where a.id = category_id)")
	private String catName;
	
	/**
	 * 所属用户
	 */
	@Column(name = "user_info_id", columnDefinition = "int(11)")
	private int userInfoId;
	
	//获取logo商家首页图
	@Formula(value="(select a.access_url from mt_material_resources a where a.id in (select b.att_id from mt_seller_gallery b where b.seller_id = id and b.sort=0))")
	private String logo;
	
	//商家视屏
	@Formula(value="(select a.access_url from mt_material_resources a where a.id in (select b.att_id from mt_seller_gallery b where b.seller_id = id and b.sort=1))")
	private String video;
	
	@Column(name = "name", columnDefinition = "varchar(100)")
	private String name;
	
	@Column(name = "address", columnDefinition = "varchar(500)")
	private String address;
	
	@Column(name = "lng", columnDefinition = "varchar(500)")
	private String lng;
	
	@Column(name = "lat", columnDefinition = "varchar(500)")
	private String lat;
	
	@Column(name = "synopsis", columnDefinition = "varchar(500)")
	private String synopsis;
	
	@Column(name = "business_scope", columnDefinition = "varchar(200)")
	private String businessScope;
	
	@Column(name = "phone_number", columnDefinition = "varchar(20)")
	private String phoneNumber;
	
	@Column(name = "remark", columnDefinition = "varchar(20)")
	private String remark;

    @Column(name="bank_account",columnDefinition = "varchar(30)" )
    private String bankAccount;
    
    /**
     * 负责人
     */
    @Column(name="responsible_peson",columnDefinition="varchar(20)")
    private String reaponsiblePeson;
                      
    @Column(name="id_number" ,columnDefinition="varchar(18)")
    private String idNumber;
	
    @Column(name="province" ,columnDefinition="varchar(50)")
    private String province;

    @Column(name="city" ,columnDefinition="varchar(50)")
    private String city;
    
    @Column(name="district" ,columnDefinition="varchar(50)")
    private String district;
    
    /**
     * 商家用户
     */
	@Transient
	private List<MtUserInfo> userInfo;

	public List<MtUserInfo> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<MtUserInfo> userInfo) {
		this.userInfo = userInfo;
	}

     /***
      * 商家素材库Id
      */
	
	@Formula(value="(select a.id from mt_material_catalog a where a.seller_id = id)")
	private int catalogId;
	
	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	/*
	 * 商家附件
	 */
	@Transient
	private List<MtSellerGallery> sellerGallery;
	
	public List<MtSellerGallery> getSellerGallery() {
		return sellerGallery;
	}

	public void setSellerGallery(List<MtSellerGallery> sellerGallery) {
		this.sellerGallery = sellerGallery;
	}

	/**
	 * 商品
	 */
	@Transient
	private List<MtGoods> goods;
	
	/**
	 * 创建人
	 * @return
	 */
	@Transient
	private int operator;
	
	
	
	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public String getSellerNo(){
		return this.sellerNo;
	}
	
	public void setSellerNo(String sellerNo){
		this.sellerNo = sellerNo;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getLng(){
		return this.lng;
	}
	
	public void setLng(String lng){
		this.lng = lng;
	}
	
	public String getLat(){
		return this.lat;
	}
	
	public void setLat(String lat){
		this.lat = lat;
	}
	
	public String getSynopsis(){
		return this.synopsis;
	}
	
	public void setSynopsis(String synopsis){
		this.synopsis = synopsis;
	}
	
	public String getBusinessScope(){
		return this.businessScope;
	}
	
	public void setBusinessScope(String businessScope){
		this.businessScope = businessScope;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<MtGoods> getGoods() {
		return goods;
	}

	public void setGoods(List<MtGoods> goods) {
		this.goods = goods;
	}
	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}


	public String getReaponsiblePeson() {
		return reaponsiblePeson;
	}

	public void setReaponsiblePeson(String reaponsiblePeson) {
		this.reaponsiblePeson = reaponsiblePeson;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}
}
