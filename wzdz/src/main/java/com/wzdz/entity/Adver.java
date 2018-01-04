package com.wzdz.entity;

import java.util.Date;

/**
 * 广告管理
 * wzdz_tb_adver
 * @author wudi
 *
 */
public class Adver {

	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private String ggNo;//广告编号
	private String ggTitle;//广告标题
	private String ggFile;//广告图片
	private long ggwId;//广告位置id
	private String ggMoney;//广告位实际价格
	private String ggArea;//区域省,市,区
	private String ggStart;//广告周期开始时间
	private String ggEnd;//广告结束时间
	
	
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
	public String getGgNo() {
		return ggNo;
	}
	public void setGgNo(String ggNo) {
		this.ggNo = ggNo;
	}
	public String getGgTitle() {
		return ggTitle;
	}
	public void setGgTitle(String ggTitle) {
		this.ggTitle = ggTitle;
	}
	public String getGgFile() {
		return ggFile;
	}
	public void setGgFile(String ggFile) {
		this.ggFile = ggFile;
	}
	public long getGgwId() {
		return ggwId;
	}
	public void setGgwId(long ggwId) {
		this.ggwId = ggwId;
	}
	public String getGgMoney() {
		return ggMoney;
	}
	public void setGgMoney(String ggMoney) {
		this.ggMoney = ggMoney;
	}
	public String getGgArea() {
		return ggArea;
	}
	public void setGgArea(String ggArea) {
		this.ggArea = ggArea;
	}
	public String getGgStart() {
		return ggStart;
	}
	public void setGgStart(String ggStart) {
		this.ggStart = ggStart;
	}
	public String getGgEnd() {
		return ggEnd;
	}
	public void setGgEnd(String ggEnd) {
		this.ggEnd = ggEnd;
	}
	
	
}
