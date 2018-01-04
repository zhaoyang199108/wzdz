package com.wzdz.entity;

import java.util.Date;

public class TrafficCon {
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String limitTime;//限行时间
	private String limitScope;//限行范围
	private String  limitRule;//限行规则
	private String other;//其他规则
	
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
	public String getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}
	public String getLimitScope() {
		return limitScope;
	}
	public void setLimitScope(String limitScope) {
		this.limitScope = limitScope;
	}
	public String getLimitRule() {
		return limitRule;
	}
	public void setLimitRule(String limitRule) {
		this.limitRule = limitRule;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}

	
	
}
