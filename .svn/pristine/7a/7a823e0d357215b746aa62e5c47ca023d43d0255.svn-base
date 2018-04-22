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
@Table(name = "mt_integrate_goods")
public class MtIntegrateGoods extends BaseEntity {
	
	@Column(name = "name", columnDefinition = "varchar(200)")
	private String name;
	
	@Column(name = "price", columnDefinition = "int(11)")
	private int price;
	
	@Column(name = "count", columnDefinition = "int(11)")
	private int count;
	
	@Column(name = "logo_att_id", columnDefinition = "int(11)")
	private int logoAttId;
	
	@Formula("( select  concat_ws('.', s.uuid, s.src_file_type) from sys_attachments s where s.id = logo_att_id)")
	private String logoAttUrl;
	
	@Column(name = "detail_info", columnDefinition = "varchar(4000)")
	private String detailInfo;
	
	@Column(name = "start_time", columnDefinition = "datetime")
	private Date startTime;
	
	@Column(name = "end_time", columnDefinition = "datetime")
	private Date endTime;
	
	@Column(name = "creator", columnDefinition = "int(11)")
	private int creator;
	
	/**
	 * 创建人
	 */
	@Formula("(select a.user_name from mt_user_info a where a.id = creator)")
	private String creatorName;
	
	
	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	@Column(name = "updator", columnDefinition = "int(11)")
	private int updator;
	
	@Column(name = "update_time", columnDefinition = "datetime")
	private Date updateTime;
	
	@Column(name = "removetor", columnDefinition = "int(11)")
	private int removetor;
	
	@Column(name = "removed_time", columnDefinition = "datetime")
	private Date removedTime;
	
	@Column(name = "if_remove", columnDefinition = "char(1)")
	private String ifRemove;
	
	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String remark;
	
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public int getCount(){
		return this.count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	public int getLogoAttId(){
		return this.logoAttId;
	}
	
	public void setLogoAttId(int logoAttId){
		this.logoAttId = logoAttId;
	}
	
	public String getDetailInfo(){
		return this.detailInfo;
	}
	
	public void setDetailInfo(String detailInfo){
		this.detailInfo = detailInfo;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  
	public Date getStartTime(){
		return this.startTime;
	}
	
	public void setStartTime(Date startTime){
		this.startTime = startTime;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  
	public Date getEndTime(){
		return this.endTime;
	}
	
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	
	public int getCreator(){
		return this.creator;
	}
	
	public void setCreator(int creator){
		this.creator = creator;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public int getUpdator(){
		return this.updator;
	}
	
	public void setUpdator(int updator){
		this.updator = updator;
	}
	
	public Date getUpdateTime(){
		return this.updateTime;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	
	public int getRemovetor(){
		return this.removetor;
	}
	
	public void setRemovetor(int removetor){
		this.removetor = removetor;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  
	public Date getRemovedTime(){
		return this.removedTime;
	}
	
	public void setRemovedTime(Date removedTime){
		this.removedTime = removedTime;
	}
	
	public String getIfRemove(){
		return this.ifRemove;
	}
	
	public void setIfRemove(String ifRemove){
		this.ifRemove = ifRemove;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getLogoAttUrl() {
		return logoAttUrl;
	}

	public void setLogoAttUrl(String logoAttUrl) {
		this.logoAttUrl = logoAttUrl;
	}
	
	
	
}
