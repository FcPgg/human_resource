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
@Table(name = "mt_user_publish_info")
public class MtUserPublishInfo extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Formula("(select u.name from mt_user_info u where u.id = user_id)")
	private String userNickName;
	
	@Column(name = "category_id", columnDefinition = "int(11)")
	private int categoryId;
	
	@Column(name = "price", columnDefinition = "decimal(18,2)")
	private double price;
	
	@Column(name = "count", columnDefinition = "int(11)")
	private int count;
	
	@Formula("(select c.name from mt_secondhand_container_category c where c.id = category_id)")
	private String categoryName;
	
	@Column(name = "title", columnDefinition = "varchar(50)")
	private String title;
	
	@Column(name = "content", columnDefinition = "varchar(4000)")
	private String content;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name = "publish_time", columnDefinition = "datetime")
	private Date publishTime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name = "update_time", columnDefinition = "datetime")
	private Date updateTime;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;
	
	@Column(name = "contractor_category", columnDefinition = "int(11)")
	private int contractorCategory;
	
	@Column(name = "contractor", columnDefinition = "varchar(100)")
	private String contractor;
	
	@Column(name = "phone_number", columnDefinition = "varchar(20)")
	private String phoneNumber;
	
	@Column(name = "address", columnDefinition = "varchar(500)")
	private String address;
	
	@Formula("(select count(*) from mt_user_read_log l where l.info_id = id)")
	private int userReadLog;
	
	@Formula("( select concat_ws('.', s.uuid, s.src_file_type) from sys_attachments s where s.id = (select a.att_id from mt_user_publish_info_atts a where a.info_id = id limit 1))")
	private String indexImgUrl;
	
	@Transient
	private List<MtUserPublishInfoAtts> atts;
	
	@Transient
	private List<MtUserPublishInfoProps> props;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getContractorCategory() {
		return contractorCategory;
	}

	public void setContractorCategory(int contractorCategory) {
		this.contractorCategory = contractorCategory;
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUserReadLog() {
		return userReadLog;
	}

	public void setUserReadLog(int userReadLog) {
		this.userReadLog = userReadLog;
	}

	public String getIndexImgUrl() {
		return indexImgUrl;
	}

	public void setIndexImgUrl(String indexImgUrl) {
		this.indexImgUrl = indexImgUrl;
	}

	public List<MtUserPublishInfoAtts> getAtts() {
		return atts;
	}

	public void setAtts(List<MtUserPublishInfoAtts> atts) {
		this.atts = atts;
	}

	public List<MtUserPublishInfoProps> getProps() {
		return props;
	}

	public void setProps(List<MtUserPublishInfoProps> props) {
		this.props = props;
	}
}
