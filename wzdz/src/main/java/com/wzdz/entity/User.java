package com.wzdz.entity;

import java.util.Date;

/**
 * 用户管理
 * wzdz_tb_user
 * @author wudi
 *
 */
public class User {
	
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private String password;//密码
	private String userName;//用户名
	private String userNamePy;//姓名简拼
	private String phoneNo;//电话号码
	private long levelId;//级别id
	private String type;//1、管理2、用户3、商家
	private String rIp;//注册ip地址
	private String rTool;//注册工具
	private int status;//状态1、正常2、黑户
	private int statusNo;//黑户次数
	private int enabled;//状态1、正常2、删除
	private String remark;//备注
	public String getUserPicture() {
		return userPicture;
	}
	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}
	private String userPicture;//用户头像
	private String gender;//用户性别
	private String birthday;//出生年月日
	private String location;//所在地
	private String nickname;//昵称
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNamePy() {
		return userNamePy;
	}
	public void setUserNamePy(String userNamePy) {
		this.userNamePy = userNamePy;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getLevelId() {
		return levelId;
	}
	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getrIp() {
		return rIp;
	}
	public void setrIp(String rIp) {
		this.rIp = rIp;
	}
	public String getrTool() {
		return rTool;
	}
	public void setrTool(String rTool) {
		this.rTool = rTool;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatusNo() {
		return statusNo;
	}
	public void setStatusNo(int statusNo) {
		this.statusNo = statusNo;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
