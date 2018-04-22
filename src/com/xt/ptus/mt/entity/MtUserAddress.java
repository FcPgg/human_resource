package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_user_address")
public class MtUserAddress extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "address", columnDefinition = "varchar(500)")
	private String address;
	
	@Column(name = "consignee", columnDefinition = "varchar(100)")
	private String consignee;
	
	@Column(name = "mobile", columnDefinition = "varchar(20)")
	private String mobile;
	
	@Column(name = "province", columnDefinition = "varchar(50)")
	private String province;

	@Column(name = "city", columnDefinition = "varchar(50)")
	private String city;
	
	@Column(name = "district", columnDefinition = "varchar(50)")
	private String district;
	
	@Column(name = "if_default", columnDefinition = "char(1)")
	private String ifDefault;
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getConsignee(){
		return this.consignee;
	}
	
	public void setConsignee(String consignee){
		this.consignee = consignee;
	}
	
	public String getMobile(){
		return this.mobile;
	}
	
	public void setMobile(String mobile){
		this.mobile = mobile;
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

	public String getIfDefault(){
		return this.ifDefault;
	}
	
	public void setIfDefault(String ifDefault){
		this.ifDefault = ifDefault;
	}
	
}
