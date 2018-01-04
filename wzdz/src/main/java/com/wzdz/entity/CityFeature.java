package com.wzdz.entity;

import java.util.Date;

/**
 * 城市特色
 * wzdz_tb_city_feature
 * @author wudi
 *
 */
public class CityFeature {

	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String content;//内容
	private String title;//标题
	private String type;//资讯类型：1-旅游咨询 2-城市要闻 3-城市热点 4-最新活动
	private String logo;//缩略图地址
	private String logoPath;//轮播图地址
	private String introduction;//简介
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	
	
	
}
