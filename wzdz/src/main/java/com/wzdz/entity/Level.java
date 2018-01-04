package com.wzdz.entity;

/**
 * 级别管理
 * wzdz_tb_level
 * @author wudi
 *
 */
public class Level {
	
	private long id;
	private String levelName;//级别名称
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	

}
