package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_order_goods")
public class MtOrderGoods extends BaseEntity {
	
	@Column(name = "order_id", columnDefinition = "int(11)")
	private int orderId;
	
	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;
	
	@Column(name = "name", columnDefinition = "varchar(1000)")
	private String name;
	
	@Column(name = "number", columnDefinition = "int(11)")
	private int number;

	@Column(name = "cashback", columnDefinition = "decimal(18,2)")
	private double cashback;
	
	/**
	 * 订单商品状态
	 * 0:正常
	 * 1:退货
	 * 2:退货完成
	 */
	@Column(name = "status", columnDefinition = "int(11)")
	private int status;
	
	/**
	 * 订单商品状态
	 */
	@Formula(value = "( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'mtOrderGoodsStatus') and b.code = status )")
	private String statusName;
	
	/**
	 * 退货单状态
	 */
	@Formula(value = "(ifnull((select c.status from mt_credit_order c where c.order_goods_id = id),0))")
	private String creditOrderStatus;
	
	@Formula(value = "(ifnull(( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'mtCreditOrderStatus') and b.code = (select c.status from mt_credit_order c where c.order_goods_id = id)),'正常'))")
	private String creditOrderStatusName;
	
	@Column(name = "postage", columnDefinition = "decimal(18,2)")
	private double postage;
	
	@Column(name = "price", columnDefinition = "decimal(18,2)")
	private double price;
	
	@Column(name = "rate", columnDefinition = "decimal(3,2)")
	private double rate;
	
	@Column(name = "spec", columnDefinition = "varchar(200)")
	private String spec;
	
	@Column(name = "remark", columnDefinition = "varchar(500)")
	private String remark;
	
	//限时抢购抢购单编号
	@Column(name = "panic_id", columnDefinition = "int")
	private int panicId;
	
	@Formula("(select m.concessional_rate from mt_panic_buying m where m.id = panic_id)")
	private String concessionalRate;
	
	//商品规格编号
	@Column(name = "spec_id", columnDefinition = "int")
	private int specId;
	
	@Formula("(select r.access_url from mt_material_resources r where r.id = (select g.resource_id from mt_goods_gallery g where g.goods_id = goods_id and g.sort = 0))")
	private String indexResourceAccessUrl;
	
	@Formula("(select g.seller_id from mt_goods g where g.id = goods_id)")
	private String sellerId;
	
	//单件商品小计
	@Transient
	private double subtotal;
	
	public int getOrderId(){
		return this.orderId;
	}
	
	public void setOrderId(int orderId){
		this.orderId = orderId;
	}
	
	public int getGoodsId(){
		return this.goodsId;
	}
	
	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public double getCashback() {
		return cashback;
	}

	public void setCashback(double cashback) {
		this.cashback = cashback;
	}

	public double getPostage(){
		return this.postage;
	}
	
	public void setPostage(double postage){
		this.postage = postage;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public double getRate(){
		return this.rate;
	}
	
	public void setRate(double rate){
		this.rate = rate;
	}
	
	public String getSpec(){
		return this.spec;
	}
	
	public void setSpec(String spec){
		this.spec = spec;
	}

	public String getIndexResourceAccessUrl() {
		return indexResourceAccessUrl;
	}

	public void setIndexResourceAccessUrl(String indexResourceAccessUrl) {
		this.indexResourceAccessUrl = indexResourceAccessUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public String getCreditOrderStatus() {
		return creditOrderStatus;
	}

	public void setCreditOrderStatus(String creditOrderStatus) {
		this.creditOrderStatus = creditOrderStatus;
	}

	public String getCreditOrderStatusName() {
		return creditOrderStatusName;
	}

	public void setCreditOrderStatusName(String creditOrderStatusName) {
		this.creditOrderStatusName = creditOrderStatusName;
	}

	public int getPanicId() {
		return panicId;
	}

	public void setPanicId(int panicId) {
		this.panicId = panicId;
	}

	public int getSpecId() {
		return specId;
	}

	public void setSpecId(int specId) {
		this.specId = specId;
	}

	public String getConcessionalRate() {
		return concessionalRate;
	}

	public void setConcessionalRate(String concessionalRate) {
		this.concessionalRate = concessionalRate;
	}
	
}
