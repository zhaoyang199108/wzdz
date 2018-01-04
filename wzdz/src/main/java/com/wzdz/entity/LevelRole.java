package com.wzdz.entity;

/**
 * 级别权限管理
 * wzdz_tb_level_role
 * @author wudi
 *
 */
public class LevelRole {
	
	private long id;
	private long levelId;//级别id
	private long roleId;//权限id
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getLevelId() {
		return levelId;
	}
	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	
	

}
