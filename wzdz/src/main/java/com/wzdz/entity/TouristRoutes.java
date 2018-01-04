package com.wzdz.entity;

import java.util.Date;

/**
 * 旅游线路管理
 * wzdz_tb_tourist_routes
 * @author wudi
 *
 */
public class TouristRoutes {
	
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private String xlName;//线路名称
	private String xlMoneyC;//线路价格成人
	private String xlMoneyH;//线路价格孩童
	private String bmTime;//报名时间
	private String ftTime;//发团时间
	private String dayCount;//形成天数
	private String bmTel;//报名电话
	private String bmAddress;//报名地址
	private String bmFile;//条幅-图片地址
	private String bmJd;//景点介绍
	private String bmPz;//景点品质
	
	
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
	public String getXlName() {
		return xlName;
	}
	public void setXlName(String xlName) {
		this.xlName = xlName;
	}
	public String getXlMoneyC() {
		return xlMoneyC;
	}
	public void setXlMoneyC(String xlMoneyC) {
		this.xlMoneyC = xlMoneyC;
	}
	public String getXlMoneyH() {
		return xlMoneyH;
	}
	public void setXlMoneyH(String xlMoneyH) {
		this.xlMoneyH = xlMoneyH;
	}
	public String getBmTime() {
		return bmTime;
	}
	public void setBmTime(String bmTime) {
		this.bmTime = bmTime;
	}
	public String getFtTime() {
		return ftTime;
	}
	public void setFtTime(String ftTime) {
		this.ftTime = ftTime;
	}
	public String getDayCount() {
		return dayCount;
	}
	public void setDayCount(String dayCount) {
		this.dayCount = dayCount;
	}
	public String getBmTel() {
		return bmTel;
	}
	public void setBmTel(String bmTel) {
		this.bmTel = bmTel;
	}
	public String getBmAddress() {
		return bmAddress;
	}
	public void setBmAddress(String bmAddress) {
		this.bmAddress = bmAddress;
	}
	public String getBmFile() {
		return bmFile;
	}
	public void setBmFile(String bmFile) {
		this.bmFile = bmFile;
	}
	public String getBmJd() {
		return bmJd;
	}
	public void setBmJd(String bmJd) {
		this.bmJd = bmJd;
	}
	public String getBmPz() {
		return bmPz;
	}
	public void setBmPz(String bmPz) {
		this.bmPz = bmPz;
	}
	

}
