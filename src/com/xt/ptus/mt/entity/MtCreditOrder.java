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
@Table(name = "mt_credit_order")
public class MtCreditOrder extends BaseEntity {

	@Column(name = "order_id", columnDefinition = "int(11)")
	private int orderId;

	@Column(name = "order_goods_id", columnDefinition = "int(11)", unique = true)
	private int orderGoodsId;

	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;

	@Column(name = "count", columnDefinition = "int(11)")
	private int count;

	@Column(name = "reason", columnDefinition = "varchar(2000)")
	private String reason;

	/*
	 * 商品名称
	 */
	@Formula(value = "(select a.name from mt_order_goods a where a.id = order_goods_id)")
	private String goodsName;

	/**
	 * 退货商品规格
	 */
	@Formula(value = "(select a.spec from mt_order_goods a where a.id = order_goods_id)")
	private String spec;
	
	/**
	 * 购买数量
	 */
	@Formula(value = "(select a.number from mt_order_goods a where a.id = order_goods_id)")
	private int buyNumber;
	
	/**
	 * 退款总金额
	 */
	@Transient
	private double sum;

	/**
	 * 商品单价
	 */
	@Transient
	private double price;

	
	/**
	 * 订单编号
	 */
	@Formula(value = "(select a.order_code from mt_order_info a where a.id in (select b.order_id from mt_order_goods b where b.id = order_goods_id))")
	private String orderCode;
	
	/**
	 * 退货人
	 * 
	 * @param orderCode
	 */
	@Formula(value="(select a.nick_name from mt_user_info a where a.id = (select b.user_id from mt_order_info b where b.id = order_id))")
	private String applicant;
	
	/**
	 * 退货单状态 
	 * 0: 正常 
	 * 1: 申请退货 
	 * 2: 商家同意退货 
	 * 3: 商家不同意退货 
	 * 4: 买家已发货 
	 * 5: 商家已收货 
	 * 6: 退货完成
	 */
	@Column(name = "status", columnDefinition = "int")
	private int status;

	/***
	 * 退货状态名称
	 */
	@Formula(value = "(select a.description from sys_dictionarys_data a where a.dictionary_id =  (select b.id from sys_dictionarys b where b.code = 'mtCreditOrderStatus') and a.code = status )")
	private String statusName;

	/**
	 * 买家选择的快递公司
	 */
	@Column(name = "stream_company", columnDefinition = "varchar(20)")
	private String streamCompany;

	/**
	 * 买家选择快递公司名字
	 */
	@Formula(value = "(select a.description from sys_dictionarys_data a where a.dictionary_id =  (select b.id from sys_dictionarys b where b.code = 'mtStreamCompany') and a.code = stream_company )")
	private String streamCompanyName;

	/**
	 * 卖家信息
	 * 
	 * @return
	 */
	@Formula(value = "(select a.name from mt_seller a where a.id in (select b.seller_id from mt_order_info b where  b.id = order_id))")
	private String sellerName;

	/**
	 * 卖家负责人
	 * 
	 * @return
	 */
	@Formula(value = "(select a.responsible_peson from mt_seller a where a.id in (select b.seller_id from mt_order_info b where  b.id = order_id))")
	private String responsiblePeson;

	/**
	 * 卖家负责人电话
	 */
	@Formula(value = "(select a.phone_number from mt_seller a where a.id in (select b.seller_id from mt_order_info b where  b.id = order_id))")
	private String phoneNumber;

	/**
	 * 买家发货单号
	 */
	@Column(name = "stream_no", columnDefinition = "varchar(200)")
	private String streamNo;

	@Column(name = "disaggree_reason", columnDefinition = "varchar(200)")
	private String disaggreeReason;

	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;

	@Transient
	private List<MtCreditOrderAttachements> attachements;

	/**
	 * 发货时间
	 */
	@Column(name = "shipped_time", columnDefinition = "datetime")
	private Date shippedTime;

	/**
	 * 收货时间
	 */
	@Column(name = "receive_time", columnDefinition = "datetime")
	private Date receiveTime;

	/**
	 * 资金流向编号
	 */
	@Column(name = "money_flow_id", columnDefinition = "int")
	private int moneyFlowId;
	
	/**
	 * 原订单详情
	 * 
	 * @return
	 */

	@Transient
	private MtOrderInfo orderInfo;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderGoodsId() {
		return orderGoodsId;
	}

	public void setOrderGoodsId(int orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStreamCompany() {
		return streamCompany;
	}

	public void setStreamCompany(String streamCompany) {
		this.streamCompany = streamCompany;
	}

	public String getStreamNo() {
		return streamNo;
	}

	public void setStreamNo(String streamNo) {
		this.streamNo = streamNo;
	}

	public String getDisaggreeReason() {
		return disaggreeReason;
	}

	public void setDisaggreeReason(String disaggreeReason) {
		this.disaggreeReason = disaggreeReason;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getShippedTime() {
		return this.shippedTime;
	}

	public void setShippedTime(Date shippedTime) {
		this.shippedTime = shippedTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public int getMoneyFlowId() {
		return moneyFlowId;
	}

	public void setMoneyFlowId(int moneyFlowId) {
		this.moneyFlowId = moneyFlowId;
	}

	public List<MtCreditOrderAttachements> getAttachements() {
		return attachements;
	}

	public void setAttachements(List<MtCreditOrderAttachements> attachements) {
		this.attachements = attachements;
	}

	public MtOrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(MtOrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getResponsiblePeson() {
		return responsiblePeson;
	}

	public void setResponsiblePeson(String responsiblePeson) {
		this.responsiblePeson = responsiblePeson;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getStreamCompanyName() {
		return streamCompanyName;
	}

	public void setStreamCompanyName(String streamCompanyName) {
		this.streamCompanyName = streamCompanyName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public int getBuyNumber() {
		return buyNumber;
	}

	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}
}
