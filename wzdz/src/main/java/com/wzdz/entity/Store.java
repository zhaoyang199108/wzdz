package com.wzdz.entity;

import java.util.Date;

/**
 * 店铺管理
 * wzdz_tb_store
 * @author wudi
 *
 */
public class Store {
	
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private String loginIdR;//审核人登录id
	private String dpName;//店铺名称
	private long typeId;//店铺类型id
	private String dpTel;//店铺电话
	private String dpContacts;//店铺联系人
	private String dpAddres;//店铺地址
	private String content;//店铺简介
	private String dpCard;//身份证件
	private String dpZz;//店铺资质
	private String status;//状态1、正常2、审核中3、暂停4、关闭
	
	
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
	public String getLoginIdR() {
		return loginIdR;
	}
	public void setLoginIdR(String loginIdR) {
		this.loginIdR = loginIdR;
	}
	public String getDpName() {
		return dpName;
	}
	public void setDpName(String dpName) {
		this.dpName = dpName;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getDpTel() {
		return dpTel;
	}
	public void setDpTel(String dpTel) {
		this.dpTel = dpTel;
	}
	public String getDpContacts() {
		return dpContacts;
	}
	public void setDpContacts(String dpContacts) {
		this.dpContacts = dpContacts;
	}
	public String getDpAddres() {
		return dpAddres;
	}
	public void setDpAddres(String dpAddres) {
		this.dpAddres = dpAddres;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDpCard() {
		return dpCard;
	}
	public void setDpCard(String dpCard) {
		this.dpCard = dpCard;
	}
	public String getDpZz() {
		return dpZz;
	}
	public void setDpZz(String dpZz) {
		this.dpZz = dpZz;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
