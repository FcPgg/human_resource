package com.xt.ptus.mt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_prizes")
public class MtPrizes extends BaseEntity {
	
	@Column(name = "title", columnDefinition = "varchar(50)")
	private String title;
	
	@Column(name = "logo", columnDefinition = "int(11)")
	private int logo;
	
	@Column(name = "integrate_count", columnDefinition = "int(11)")
	private int integrateCount;
	
	@Column(name = "prizes_category", columnDefinition = "varchar(20)")
	private String prizesCategory;
	
	@Column(name = "count", columnDefinition = "int(11)")
	private int count;
	
	@Column(name = "background_color", columnDefinition = "varchar(10)")
	private String backgroundColor;
	
	@Column(name = "winning_rate", columnDefinition = "int(11)")
	private int winningRate;
	
	@Column(name = "sort", columnDefinition = "int(11)")
	private int sort;
	
	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String remark;
	
	
	@Formula("( select concat_ws('.',s.uuid,s.src_file_type) from sys_attachments s where s.id = logo)")
	private String logoUrl;
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public int getLogo(){
		return this.logo;
	}
	
	public void setLogo(int logo){
		this.logo = logo;
	}
	
	public int getIntegrateCount() {
		return integrateCount;
	}

	public void setIntegrateCount(int integrateCount) {
		this.integrateCount = integrateCount;
	}

	public String getPrizesCategory(){
		return this.prizesCategory;
	}
	
	public void setPrizesCategory(String prizesCategory){
		this.prizesCategory = prizesCategory;
	}
	
	public int getCount(){
		return this.count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	public String getBackgroundColor(){
		return this.backgroundColor;
	}
	
	public void setBackgroundColor(String backgroundColor){
		this.backgroundColor = backgroundColor;
	}
	
	public int getWinningRate(){
		return this.winningRate;
	}
	
	public void setWinningRate(int winningRate){
		this.winningRate = winningRate;
	}
	
	public int getSort(){
		return this.sort;
	}
	
	public void setSort(int sort){
		this.sort = sort;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
}
