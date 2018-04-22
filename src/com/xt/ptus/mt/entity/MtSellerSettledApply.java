package com.xt.ptus.mt.entity;


import java.util.Date;
import java.util.List;

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
@Table(name = "mt_seller_settled_apply")
public class MtSellerSettledApply extends BaseEntity {
	
	@Column(name = "user_id" , columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "category_id", columnDefinition = "int(11)")
	private int categoryId;
	
	@Formula(value="(select a.cat_name from mt_category a where a.id = category_id)")
	private String catName;
	
	
	@Column(name = "name", columnDefinition = "varchar(100)")
	private String name;
	
	@Column(name = "responsible_peson", columnDefinition = "varchar(100)")
	private String reaponsiblePeson;
	
	@Column(name = "id_number", columnDefinition = "varchar(20)")
	private String idNumber;
	
	@Column(name = "bank_account", columnDefinition = "varchar(20)")
	private String bankAccount;
	
	@Column(name = "province", columnDefinition = "varchar(50)")
	private String province;
	
	@Column(name = "city", columnDefinition = "varchar(50)")
	private String city;
	
	@Column(name = "district", columnDefinition = "varchar(50)")
	private String district;
	
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
	
	@Column(name = "logo", columnDefinition = "varchar(500)")
	private String logo;
	
	@Column(name = "phone_number", columnDefinition = "varchar(20)")
	private String phoneNumber;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;
	
	@Column(name="apply_time" , columnDefinition = "datetime")
	private Date applyTime;
	
	/**
	 * 状态
	 * 0:待审核
	 * 1:审核通过(待付款)
	 * 3:审核未通过
	 * 6:已认证
	 */
	@Column(name = "status" , columnDefinition = "int(11)")
	private int status;
	
	@Column(name="fail_reason",columnDefinition = "varchar(1000)")
	private String failReason;
	
	@Formula(value="(select a.description from sys_dictionarys_data a where a.dictionary_id =  (select b.id from sys_dictionarys b where b.code = 'mtSellerApplyStatus') and a.code = status )")
    private String statusName;
	
	@Column(name="create_time",columnDefinition = "datetime")
	private Date createTime;
	
	@Transient
	private List<MtApplyAttachment> applyAttachment;
		
	
	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<MtApplyAttachment> getApplyAttachment() {
		return applyAttachment;
	}

	public void setApplyAttachment(List<MtApplyAttachment> applyAttachment) {
		this.applyAttachment = applyAttachment;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public int getCategoryId(){
		return this.categoryId;
	}
	
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	

	
	public String getReaponsiblePeson() {
		return reaponsiblePeson;
	}

	public void setReaponsiblePeson(String reaponsiblePeson) {
		this.reaponsiblePeson = reaponsiblePeson;
	}

	public String getIdNumber(){
		return this.idNumber;
	}
	
	public void setIdNumber(String idNumber){
		this.idNumber = idNumber;
	}
	
	public String getBankAccount(){
		return this.bankAccount;
	}
	
	public void setBankAccount(String bankAccount){
		this.bankAccount = bankAccount;
	}
	
	public String getProvince(){
		return this.province;
	}
	
	public void setProvince(String province){
		this.province = province;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getDistrict(){
		return this.district;
	}
	
	public void setDistrict(String district){
		this.district = district;
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
	
	public String getLogo(){
		return this.logo;
	}
	
	public void setLogo(String logo){
		this.logo = logo;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
