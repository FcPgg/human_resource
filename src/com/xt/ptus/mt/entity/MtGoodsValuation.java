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
@Table(name = "mt_goods_valuation")
public class MtGoodsValuation extends BaseEntity {
	
	@Column(name = "order_id", columnDefinition = "int(11)")
	private int orderId;
	
	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "contents", columnDefinition = "varchar(2000)")
	private String contents;
	
	@Column(name = "match_description", columnDefinition = "int(11)")
	private int matchDescription;
	
	@Column(name = "stream_service", columnDefinition = "int(11)")
	private int streamService;
	
	@Column(name = "service_attitude", columnDefinition = "int(11)")
	private int serviceAttitude;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  
	@Column(name = "valuation_time", columnDefinition = "datetime")
	private Date valuationTime;
	
	@Formula("( select u.nick_name from mt_user_info u where user_id = u.id)")
	private String userNickName;
	
	@Formula("( select concat_ws('.', a.uuid, a.src_file_type) from sys_attachments a where a.id = (select u.head_img_att_id from mt_user_info u where user_id = u.id) )")
	private String headImgUrl;
	
	@Formula("( select count(*) from mt_goods_valuation v where v.goods_id = goods_id )")
	private int valuationCount;
	
	@Formula("( select u.spec from mt_order_goods u where goods_id = u.goods_id and order_id = u.order_id)")
	private String specName;
	
	@Transient
	private List<MtGoodsValuationAttachements> attachements;
	
	/**
	 * 回复
	 * @return
	 */
	@Transient
	private List<MtGoodsValuationReply> reply;
	
	
	public List<MtGoodsValuationReply> getReply() {
		return reply;
	}

	public void setReply(List<MtGoodsValuationReply> reply) {
		this.reply = reply;
	}

	public int getOrderId(){
		return this.orderId;
	}
	
	public void setOrderId(int orderId){
		this.orderId = orderId;
	}
	
	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public String getContents(){
		return this.contents;
	}
	
	public void setContents(String contents){
		this.contents = contents;
	}
	
	public int getMatchDescription(){
		return this.matchDescription;
	}
	
	public void setMatchDescription(int matchDescription){
		this.matchDescription = matchDescription;
	}
	
	public int getStreamService(){
		return this.streamService;
	}
	
	public void setStreamService(int streamService){
		this.streamService = streamService;
	}
	
	public int getServiceAttitude(){
		return this.serviceAttitude;
	}
	
	public void setServiceAttitude(int serviceAttitude){
		this.serviceAttitude = serviceAttitude;
	}

	public Date getValuationTime() {
		return valuationTime;
	}

	public void setValuationTime(Date valuationTime) {
		this.valuationTime = valuationTime;
	}

	public List<MtGoodsValuationAttachements> getAttachements() {
		return attachements;
	}

	public void setAttachements(List<MtGoodsValuationAttachements> attachements) {
		this.attachements = attachements;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public int getValuationCount() {
		return valuationCount;
	}

	public void setValuationCount(int valuationCount) {
		this.valuationCount = valuationCount;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}
}
