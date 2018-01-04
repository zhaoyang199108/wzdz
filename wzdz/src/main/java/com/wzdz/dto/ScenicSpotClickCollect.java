package com.wzdz.dto;

import java.util.Date;

/**
 * 小胖攻略点赞
 * @author wudi
 *
 */
public class ScenicSpotClickCollect {

	private long id;
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public int getCollect() {
		return collect;
	}
	public void setCollect(int collect) {
		this.collect = collect;
	}
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String loginId;//操作人登录id
	private String title;//标题
	private String option;//描述
	private String content;//内容
	private String owner;//提供者
	private String logo;//缩略图地址
	private String logoPath;//轮播图地址
	private String icon;//头像地址
	private int click;//点赞
	private int collect;//收藏
	private String type;//类型
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

}
