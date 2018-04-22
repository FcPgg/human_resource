package com.xt.ptus.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "sys_staff_info")
public class SysStaffInfo extends BaseEntity {
	
	@Column(name = "name", columnDefinition = "varchar(20)")
	private String name;
	
	@Column(name = "sex", columnDefinition = "int(11)")
	private int sex;
	
	@Formula(value = "( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'gender') and b.code = sex)")
	private String gender;
	
	@Column(name = "id_card", columnDefinition = "varchar(20)")
	private String idCard;
	
	@Column(name = "post", columnDefinition = "int(11)")
	private int post;
	
	@Formula(value = "( select b.description from sys_dictionarys_data b where b.dictionary_id = (select a.id from sys_dictionarys a where a.code = 'post') and b.code = post)")
	private String postDesc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public String getPostDesc() {
		return postDesc;
	}

	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}
}
