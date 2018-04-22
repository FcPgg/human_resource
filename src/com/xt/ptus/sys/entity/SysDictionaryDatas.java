package com.xt.ptus.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "sys_dictionarys_data")
public class SysDictionaryDatas extends BaseEntity {
	
	/**
	 * 字典编号
	 */
	@Column(name = "dictionary_id", columnDefinition = "int")
	private int dictionaryId;
	
	/**
	 * 代码
	 */
	@Column(name = "code", columnDefinition = "varchar(100)")
	private String code;
	
	/**
	 * 中文描述
	 */
	@Column(name = "description", columnDefinition = "varchar(100)")
	private String description;
	
	/**
	 * 表达式
	 */
	@Column(name = "expression", columnDefinition = "varchar(100)")
	private String expression;

	public int getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(int dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
}
