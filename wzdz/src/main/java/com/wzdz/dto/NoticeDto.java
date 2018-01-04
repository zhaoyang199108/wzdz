package com.wzdz.dto;

import java.util.Date;
import java.util.List;

public class NoticeDto {
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private String title;
	private String content;
	private String type;
	private String  logoPath;
	private String isread;
	private String[] icon;

	public String[] getIcon() {
		return icon;
	}
	public void setIcon(String[] icon) {
		this.icon = icon;
	}
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
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getIsread() {
		return isread;
	}
	public void setIsread(String isread) {
		this.isread = isread;
	}
}
