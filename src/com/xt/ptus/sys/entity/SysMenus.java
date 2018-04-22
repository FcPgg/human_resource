package com.xt.ptus.sys.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xt.ptus.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "sys_menus")
public class SysMenus extends BaseEntity {

	@Column(name = "pid", columnDefinition = "int")
	private Integer pid;

	@Column(name = "name", columnDefinition = "varchar(20)")
	private String name;

	@Column(name = "level", columnDefinition = "int")
	private Integer level;

	/**
	 * URL地址----对应Controller中的地址
	 */
	@Column(name = "uri", columnDefinition = "varchar(100)")
	private String uri;

	@Column(name = "remark", columnDefinition = "varchar(200)")
	private String remark;
	
	@Column(name = "title", columnDefinition = "varchar(100)")
	private String title;
	
	@Column(name="action",columnDefinition="varchar(100)")
	private String action;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 页面路径
	 */
	@Column(name = "page_path", columnDefinition = "varchar(200)")
	private String pagePath;
	
	@Transient
	private List<SysMenus> children = new ArrayList<SysMenus>();

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri == null ? null : uri.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<SysMenus> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenus> children) {
		this.children = children;
	}
}