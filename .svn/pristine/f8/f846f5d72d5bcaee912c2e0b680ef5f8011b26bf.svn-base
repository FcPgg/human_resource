package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_credit_order_attachements")
public class MtCreditOrderAttachements extends BaseEntity {
	
	@Column(name = "credit_order_id", columnDefinition = "int(11)")
	private int creditOrderId;
	
	@Column(name = "attachements_id", columnDefinition = "int(11)")
	private int attachementsId;
	
	public int getCreditOrderId(){
		return this.creditOrderId;
	}
	
	public void setCreditOrderId(int creditOrderId){
		this.creditOrderId = creditOrderId;
	}
	
	public int getAttachementsId(){
		return this.attachementsId;
	}
	
	public void setAttachementsId(int attachementsId){
		this.attachementsId = attachementsId;
	}
	
	
	/**
	 * 获取用户退货图片名称
	 */
	@Formula(value="(select a.uuid from sys_attachments a where a.id = attachements_id)")
	private String photoName;
	
	 /**
	  * 获取图片类型
	  */
	@Formula(value="(select a.src_file_type from sys_attachments a where a.id = attachements_id)")
	private String PhotoType;

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoType() {
		return PhotoType;
	}

	public void setPhotoType(String photoType) {
		PhotoType = photoType;
	}
	
	
}
