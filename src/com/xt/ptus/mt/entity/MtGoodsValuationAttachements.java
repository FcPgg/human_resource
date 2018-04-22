package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_goods_valuation_attachements")
public class MtGoodsValuationAttachements extends BaseEntity {
	
	@Column(name = "valuation_id", columnDefinition = "int(11)")
	private int valuationId;
	
	@Column(name = "attachements_id", columnDefinition = "int(11)")
	private int attachementsId;
	
	@Formula("( select concat_ws('.', s.uuid, s.src_file_type) from sys_attachments s where s.id = attachements_id)")
	private String attachementUrl;
	
	public int getValuationId(){
		return this.valuationId;
	}
	
	public void setValuationId(int valuationId){
		this.valuationId = valuationId;
	}
	
	public int getAttachementsId(){
		return this.attachementsId;
	}
	
	public void setAttachementsId(int attachementsId){
		this.attachementsId = attachementsId;
	}

	public String getAttachementUrl() {
		return attachementUrl;
	}

	public void setAttachementUrl(String attachementUrl) {
		this.attachementUrl = attachementUrl;
	}
	
}
