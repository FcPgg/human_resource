package com.xt.ptus.mt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_secondhand_container_category")
public class MtSecondhandContainerCategory extends BaseEntity {
	
	@Column(name = "name", columnDefinition = "varchar(20)")
	private String name;
	
	@Column(name = "logo_att_id", columnDefinition = "int(11)")
	private int logoAttId;
	
	@Column(name = "if_need_trade", columnDefinition = "int(11)")
	private int ifNeedTrade;
	
	@Formula("( select concat_ws('.',s.uuid,s.src_file_type) from sys_attachments s where s.id = logo_att_id)")
	private String logoAttUrl;
	
	@Transient
	private List<MtUserPublishPropsTemplate> props;
	
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getLogoAttId(){
		return this.logoAttId;
	}
	
	public void setLogoAttId(int logoAttId){
		this.logoAttId = logoAttId;
	}
	
	public String getLogoAttUrl() {
		return logoAttUrl;
	}

	public void setLogoAttUrl(String logoAttUrl) {
		this.logoAttUrl = logoAttUrl;
	}

	public List<MtUserPublishPropsTemplate> getProps() {
		return props;
	}

	public void setProps(List<MtUserPublishPropsTemplate> props) {
		this.props = props;
	}

	public int getIfNeedTrade() {
		return ifNeedTrade;
	}

	public void setIfNeedTrade(int ifNeedTrade) {
		this.ifNeedTrade = ifNeedTrade;
	}
}
