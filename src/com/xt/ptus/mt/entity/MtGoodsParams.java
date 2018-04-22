package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_goods_params")
public class MtGoodsParams extends BaseEntity {
	
	@Column(name = "goods_id", columnDefinition = "int(11)")
	private int goodsId;
	
	@Column(name = "param_name", columnDefinition = "varchar(100)")
	private String paramName;
	
	@Column(name = "param_value", columnDefinition = "varchar(2000)")
	private String paramValue;
	
	
	public int getGoodsId(){
		return this.goodsId;
	}
	
	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}
	
	public String getParamName(){
		return this.paramName;
	}
	
	public void setParamName(String paramName){
		this.paramName = paramName;
	}
	
	public String getParamValue(){
		return this.paramValue;
	}
	
	public void setParamValue(String paramValue){
		this.paramValue = paramValue;
	}
	
}
