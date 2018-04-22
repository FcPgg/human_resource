package com.xt.ptus.mt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xt.ptus.base.BaseEntity;

@Entity
@SuppressWarnings("serial")
@Table(name = "mt_message_conversations")
public class MtMessageConversations extends BaseEntity {
	
	/**
	 * 来源
	 */
	@Column(name = "source", columnDefinition = "int(11)")
	private int source;
	
	/**
	 * 目标
	 */
	@Column(name = "target", columnDefinition = "int(11)")
	private int target;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	/**
	 * 发送者昵称
	 */
	@Formula("( select u.nick_name from mt_user_info u where source = u.id)")
	private String userNickName;
	
	/**
	 * 发送者头像
	 */
	@Formula("( select concat_ws('.', a.uuid, a.src_file_type) from sys_attachments a where a.id = (select u.head_img_att_id from mt_user_info u where source = u.id) )")
	private String headImgUrl;
	
	/**
	 * 接收者昵称
	 */
	@Formula("( select u.nick_name from mt_user_info u where target = u.id)")
	private String targetUserNickName;
	
	/**
	 * 接收者头像
	 */
	@Formula("( select concat_ws('.', a.uuid, a.src_file_type) from sys_attachments a where a.id = (select u.head_img_att_id from mt_user_info u where target = u.id) )")
	private String targetHeadImgUrl;
	
	@Formula("(select DATE_FORMAT(c.create_time,'%Y/%m/%d') from mt_message_contents c where c.conversation_id in ( select v.id from mt_message_conversations v where (v.source = source and v.target = target) or (v.source = target and v.target = source)) ORDER BY create_time DESC limit 1)")
	private String lastChatTime;
	
	@Formula("(select c.content from mt_message_contents c where c.conversation_id in ( select v.id from mt_message_conversations v where (v.source = source and v.target = target) or (v.source = target and v.target = source)) ORDER BY create_time DESC limit 1)")
	private String lastChatContent;
	
	public int getSource(){
		return this.source;
	}
	
	public void setSource(int source){
		this.source = source;
	}
	
	public int getTarget(){
		return this.target;
	}
	
	public void setTarget(int target){
		this.target = target;
	}
	
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getLastChatContent() {
		return lastChatContent;
	}

	public void setLastChatContent(String lastChatContent) {
		this.lastChatContent = lastChatContent;
	}

	public String getLastChatTime() {
		return lastChatTime;
	}

	public void setLastChatTime(String lastChatTime) {
		this.lastChatTime = lastChatTime;
	}

	public String getTargetUserNickName() {
		return targetUserNickName;
	}

	public void setTargetUserNickName(String targetUserNickName) {
		this.targetUserNickName = targetUserNickName;
	}

	public String getTargetHeadImgUrl() {
		return targetHeadImgUrl;
	}

	public void setTargetHeadImgUrl(String targetHeadImgUrl) {
		this.targetHeadImgUrl = targetHeadImgUrl;
	}
}
