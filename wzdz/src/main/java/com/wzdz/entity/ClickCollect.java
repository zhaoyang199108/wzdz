package com.wzdz.entity;

import java.util.Date;

/**
 * 点赞收藏明细
 * wzdz_tb_click_collect
 * @author wudi
 *
 */
public class ClickCollect {
	
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private String click;//是否点赞 1.点赞 0.取消点赞
	private String collect;//是否收藏 1.收藏 0.取消收藏
	private String type;//模块类型：1.周边景点	 2.城市热点	3.旅游攻略（小胖攻略）
	private String typeId;
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
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
	public String getClick() {
		return click;
	}
	public void setClick(String click) {
		this.click = click;
	}
	public String getCollect() {
		return collect;
	}
	public void setCollect(String collect) {
		this.collect = collect;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
