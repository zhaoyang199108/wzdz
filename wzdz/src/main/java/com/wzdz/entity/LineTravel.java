package com.wzdz.entity;

/**
 * 线路行程
 * wzdz_tb_line_travel
 * @author wudi
 *
 */
public class LineTravel {
	
	private long id;
	private long xlId;//线路id
	private String xcDay;//行程天数
	private String xcName;//行程名称
	private String xcContent;//行程描述
	private String xcEat;//行程餐饮
	private String xcLive;//行程天数
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getXlId() {
		return xlId;
	}
	public void setXlId(long xlId) {
		this.xlId = xlId;
	}
	public String getXcDay() {
		return xcDay;
	}
	public void setXcDay(String xcDay) {
		this.xcDay = xcDay;
	}
	public String getXcName() {
		return xcName;
	}
	public void setXcName(String xcName) {
		this.xcName = xcName;
	}
	public String getXcContent() {
		return xcContent;
	}
	public void setXcContent(String xcContent) {
		this.xcContent = xcContent;
	}
	public String getXcEat() {
		return xcEat;
	}
	public void setXcEat(String xcEat) {
		this.xcEat = xcEat;
	}
	public String getXcLive() {
		return xcLive;
	}
	public void setXcLive(String xcLive) {
		this.xcLive = xcLive;
	}
	
	
	
	

}
