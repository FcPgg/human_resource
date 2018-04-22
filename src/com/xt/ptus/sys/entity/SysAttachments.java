package com.xt.ptus.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xt.ptus.base.BaseEntity;


@Entity
@SuppressWarnings("serial")
@Table(name = "sys_attachments")
public class SysAttachments extends BaseEntity{

	@Column(name = "src_file_name", columnDefinition = "varchar(100)")
	private String srcFileName;
	
	@Column(name = "src_file_type", columnDefinition = "varchar(100)")
	private String srcFileType;
	
	@Column(name = "uuid", columnDefinition = "varchar(100)")
	private String uuid;

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public String getSrcFileType() {
		return srcFileType;
	}

	public void setSrcFileType(String srcFileType) {
		this.srcFileType = srcFileType;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
