package com.xt.ptus.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 基础entity Bean类，用于包装bean实体
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int")
	private String id; // 编号

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
