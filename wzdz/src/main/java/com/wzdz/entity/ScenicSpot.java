package com.wzdz.entity;

import java.util.Date;

/**
 * 景区管理
 * wzdz_tb_scenic_spot
 * @author wudi
 *
 */
public class ScenicSpot {

	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private String jqName;//景区名称
	private String jqAddres;//景区地址
	private int  jqLevel;//景区级别1、国家3a
	private String jqMoney;//门票
	private String jqVoice;//语音文件路径
	private String content;//内容
	private String stauts;//状态：区分城市和周边景区：1.城市 2.周边
	private String  area;//地域
	private String  logo;//缩略图地址
	private String  logoPath;//缩略图地址
	private String  jqTel;//电话
	private String introduction;//简介
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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
	public String getJqName() {
		return jqName;
	}
	public void setJqName(String jqName) {
		this.jqName = jqName;
	}
	public String getJqAddres() {
		return jqAddres;
	}
	public void setJqAddres(String jqAddres) {
		this.jqAddres = jqAddres;
	}
	public int getJqLevel() {
		return jqLevel;
	}
	public void setJqLevel(int jqLevel) {
		this.jqLevel = jqLevel;
	}
	public String getJqMoney() {
		return jqMoney;
	}
	public void setJqMoney(String jqMoney) {
		this.jqMoney = jqMoney;
	}
	public String getJqVoice() {
		return jqVoice;
	}
	public void setJqVoice(String jqVoice) {
		this.jqVoice = jqVoice;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getJqTel() {
		return jqTel;
	}
	public void setJqTel(String jqTel) {
		this.jqTel = jqTel;
	}
	
	
	
}
