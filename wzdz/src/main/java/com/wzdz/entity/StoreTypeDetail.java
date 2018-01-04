package com.wzdz.entity;

import java.util.Date;

/**
 * 店铺类型详细管理
 * wzdz_tb_store_type_detail
 * @author Administrator
 *
 */
public class StoreTypeDetail {
	
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private long typeId;//类型id
	private String detailName;//类型详细名称
	
	
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
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	

}
