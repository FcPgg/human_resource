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
@Table(name = "mt_message_contents")
public class MtMessageContents extends BaseEntity {
	
	@Column(name = "conversation_id", columnDefinition = "int(11)")
	private int conversationId;
	
	@Column(name = "user_id", columnDefinition = "int(11)")
	private int userId;
	
	@Column(name = "type", columnDefinition = "varchar(20)")
	private String type;
	
	@Column(name = "content", columnDefinition = "varchar(2000)")
	private String content;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
	@Column(name = "create_time", columnDefinition = "datetime")
	private Date createTime;
	
	@Column(name = "message_id", columnDefinition = "varchar(100)")
	private String messageId;
	
	@Formula("( select u.nick_name from mt_user_info u where user_id = u.id)")
	private String userNickName;
	
	@Formula("( select concat_ws('.', a.uuid, a.src_file_type) from sys_attachments a where a.id = (select u.head_img_att_id from mt_user_info u where user_id = u.id) )")
	private String headImgUrl;
	
	public int getConversationId(){
		return this.conversationId;
	}
	
	public void setConversationId(int conversationId){
		this.conversationId = conversationId;
	}
	
	public int getUserId(){
		return this.userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public String getMessageId(){
		return this.messageId;
	}
	
	public void setMessageId(String messageId){
		this.messageId = messageId;
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
}
