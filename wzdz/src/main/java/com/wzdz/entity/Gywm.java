package com.wzdz.entity;

import java.util.Date;

public class Gywm {
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String logo;
	private String hotPhone;
	private String wxpt;
	private String version;
	private String ptwz;
	public String getPtwz() {
		return ptwz;
	}
	public void setPtwz(String ptwz) {
		this.ptwz = ptwz;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getHotPhone() {
		return hotPhone;
	}
	public void setHotPhone(String hotPhone) {
		this.hotPhone = hotPhone;
	}
	public String getWxpt() {
		return wxpt;
	}
	public void setWxpt(String wxpt) {
		this.wxpt = wxpt;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
