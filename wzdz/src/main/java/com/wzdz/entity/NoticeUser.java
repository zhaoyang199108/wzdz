package com.wzdz.entity;

import java.util.Date;

public class NoticeUser {

	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String phone;
	private long noticeId;
	private String isread;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(long noticeId) {
		this.noticeId = noticeId;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
}
