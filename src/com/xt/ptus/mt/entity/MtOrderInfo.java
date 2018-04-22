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
@Table(name = "mt_order_info")
public class MtOrderInfo extends BaseEntity {
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "order_code", columnDefinition = "varchar(100)", unique = true)
	private String orderCode;
	
	@Column(name = "seller_id", columnDefinition = "int(11)")
	private int sellerId;
	
	/**
	 * 订单状态
	 */
	@Column(name = "order_status", columnDefinition = "int(11)")
	private int orderStatus;
	
	/**
	 * 订单状态名称
	 */
	@Formula(value = "( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'mtOrderStatus') and b.code = order_status )")
	private String orderStatusName;
	
	/**
	 * 支付方式
	 * amount:余额支付
	 * alipay:支付宝支付
	 * wxpay:微信支付
	 */
	@Column(name = "pay_methods", columnDefinition = "varchar(11)")
	private String payMethods;
	
	/**
	 * 支付状态
	 */
	@Column(name = "pay_status", columnDefinition = "int(11)")
	private int payStatus;
	
	/**
	 * 支付状态名称
	 */
	@Formula(value = "( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'mtOrderPayStatus') and b.code = pay_status )")
	private String payStatusName;
	
	/**
	 * 物流状态
	 */
	@Column(name = "stream_status", columnDefinition = "int(11)")
	private int streamStatus;
	
	/**
	 * 物流状态名称
	 */
	@Formula(value = "( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'mtOrderStreamStatus') and b.code = stream_status )")
	private String streamStatusName;
	
	@Column(name = "pary_no", columnDefinition = "varchar(2000)")
	private String paryNo;
	
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	@Column(name = "user_address_id", columnDefinition = "int(11)")
	private int userAddressId;
	
	@Column(name = "consignee", columnDefinition = "varchar(10)")
	private String consignee;
	
	@Column(name = "address", columnDefinition = "varchar(1000)")
	private String address;
	
	@Column(name = "phone_number", columnDefinition = "varchar(20)")
	private String phoneNumber;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;
	
	@Column(name = "tracking_no", columnDefinition = "varchar(1000)")
	private String trackingNo;
	
	@Column(name="stream_company_no" , columnDefinition="varchar(50)")
	private String streamCompanyNo;

	/**
	 * 支付时间
	 */
	@Column(name = "paied_time", columnDefinition = "datetime")
	private Date paiedTime;
	
	/**
	 * 确认收货时间
	 */
	@Column(name = "received_time", columnDefinition = "datetime")
	private Date receivedTime;
	
	@Column(name = "shippor", columnDefinition = "int")
	private int shippor;
	
	@Column(name = "shipped_time", columnDefinition = "datetime")
	private Date shippedTime;
	
	/**
	 * 退货标记
	 * 0: 未发生退货
	 * 1: 发生退货
	 */
	@Column(name = "if_return_goods", columnDefinition = "int")
	private int ifReturnGoods;
	
	@Transient
	private double sum;
	
	@Transient 
	private List<MtOrderGoods> orderGoods;
	
	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public String getOrderCode(){
		return this.orderCode;
	}
	
	public void setOrderCode(String orderCode){
		this.orderCode = orderCode;
	}
	
	public int getOrderStatus(){
		return this.orderStatus;
	}
	
	public void setOrderStatus(int orderStatus){
		this.orderStatus = orderStatus;
	}
	
	public int getPayStatus(){
		return this.payStatus;
	}
	
	public void setPayStatus(int payStatus){
		this.payStatus = payStatus;
	}
	
	public String getPayMethods() {
		return payMethods;
	}

	public void setPayMethods(String payMethods) {
		this.payMethods = payMethods;
	}

	public String getParyNo(){
		return this.paryNo;
	}
	
	public void setParyNo(String paryNo){
		this.paryNo = paryNo;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public int getUserAddressId(){
		return this.userAddressId;
	}
	
	public void setUserAddressId(int userAddressId){
		this.userAddressId = userAddressId;
	}
	
	public String getConsignee(){
		return this.consignee;
	}
	
	public void setConsignee(String consignee){
		this.consignee = consignee;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address = address;
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

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public List<MtOrderGoods> getOrderGoods() {
		return orderGoods;
	}

	public void setOrderGoods(List<MtOrderGoods> orderGoods) {
		this.orderGoods = orderGoods;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public String getPayStatusName() {
		return payStatusName;
	}

	public void setPayStatusName(String payStatusName) {
		this.payStatusName = payStatusName;
	}

	public int getStreamStatus() {
		return streamStatus;
	}

	public void setStreamStatus(int streamStatus) {
		this.streamStatus = streamStatus;
	}

	public String getStreamStatusName() {
		return streamStatusName;
	}

	public void setStreamStatusName(String streamStatusName) {
		this.streamStatusName = streamStatusName;
	}

	public String getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}

	public int getIfReturnGoods() {
		return ifReturnGoods;
	}

	public void setIfReturnGoods(int ifReturnGoods) {
		this.ifReturnGoods = ifReturnGoods;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getPaiedTime() {
		return paiedTime;
	}

	public void setPaiedTime(Date paiedTime) {
		this.paiedTime = paiedTime;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getReceivedTime() {
		return this.receivedTime;
	}

	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}
	public String getStreamCompanyNo() {
		return streamCompanyNo;
	}

	public void setStreamCompanyNo(String streamCompanyNo) {
		this.streamCompanyNo = streamCompanyNo;
	}

	public int getShippor() {
		return shippor;
	}

	public void setShippor(int shippor) {
		this.shippor = shippor;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	public Date getShippedTime() {
		return shippedTime;
	}

	public void setShippedTime(Date shippedTime) {
		this.shippedTime = shippedTime;
	}
}
