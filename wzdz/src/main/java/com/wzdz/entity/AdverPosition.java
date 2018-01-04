package com.wzdz.entity;

import java.util.Date;

/**
 *广告位管理
 *wzdz_tb_adver_position
 * @author wudi
 *
 */
public class AdverPosition {
	
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private String ggwName;//广告位名称
	private String ggwMoney;//广告位价格
	
	
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
	public String getGgwName() {
		return ggwName;
	}
	public void setGgwName(String ggwName) {
		this.ggwName = ggwName;
	}
	public String getGgwMoney() {
		return ggwMoney;
	}
	public void setGgwMoney(String ggwMoney) {
		this.ggwMoney = ggwMoney;
	}
	

}
