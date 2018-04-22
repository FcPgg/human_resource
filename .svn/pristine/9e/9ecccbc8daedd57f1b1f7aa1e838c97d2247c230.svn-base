package com.xt.ptus.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.xt.ptus.base.BaseEntity;

/**
 * 系统数据字典
 * @author win7
 *
 */
@Entity
@SuppressWarnings("serial")
@Table(name = "sys_dictionarys", uniqueConstraints = {@UniqueConstraint(columnNames={"code"})})
public class SysDictionarys extends BaseEntity {
	
	/**
	 * 名称
	 */
	@Column(name = "name", columnDefinition = "varchar(30)")
	private String name;
	
	/**
	 * 表达式
	 */
	@Column(name = "expression", columnDefinition = "varchar(200)")
	private String expression;
	
	/**
	 * 系统
	 */
	@Column(name = "system_name", columnDefinition = "varchar(50)")
	private String systemName;
	
	/**
	 * 代码
	 */
	@Column(name = "code", columnDefinition = "varchar(50)")
	private String code;
	
	/**
	 * 表达式
	 */
	@Column(name = "description", columnDefinition = "varchar(200)")
	private String description;
	
	/**
	 * 值字段
	 */
	@Column(name = "value_field", columnDefinition = "varchar(50)")
	private String valueField;
	
	/**
	 * 显示字段
	 */
	@Column(name = "display_field", columnDefinition = "varchar(50)")
	private String displayField;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
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

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getDisplayField() {
		return displayField;
	}

	public void setDisplayField(String displayField) {
		this.displayField = displayField;
	}
}
