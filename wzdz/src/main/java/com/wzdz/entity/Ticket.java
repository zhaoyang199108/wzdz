package com.wzdz.entity;

import java.util.Date;

/**
 * 票务
 * @author wudi
 *
 */
public class Ticket {
	
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private String pwName;//票务名称
	private String pwAddres;//票务地址
	private String  pwTel;//电话
	private String pwMoney;//票价
	private String  area;//地域
	private String logo;//缩略图
	
	
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
	public String getPwName() {
		return pwName;
	}
	public void setPwName(String pwName) {
		this.pwName = pwName;
	}
	public String getPwAddres() {
		return pwAddres;
	}
	public void setPwAddres(String pwAddres) {
		this.pwAddres = pwAddres;
	}
	public String getPwTel() {
		return pwTel;
	}
	public void setPwTel(String pwTel) {
		this.pwTel = pwTel;
	}
	public String getPwMoney() {
		return pwMoney;
	}
	public void setPwMoney(String pwMoney) {
		this.pwMoney = pwMoney;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	
	
	
	
	

}
