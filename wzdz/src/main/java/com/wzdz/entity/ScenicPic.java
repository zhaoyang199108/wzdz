package com.wzdz.entity;

import java.util.Date;

/**
 * 景区图集管理
 * wzdz_tb_scenic_pic
 * @author wudi
 *
 */
public class ScenicPic {
	
	private long id;
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private long jqId;//景区id
	private String fileDir;//景区图片路径
	
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
	public long getJqId() {
		return jqId;
	}
	public void setJqId(long jqId) {
		this.jqId = jqId;
	}
	public String getFileDir() {
		return fileDir;
	}
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}
	
	
}
