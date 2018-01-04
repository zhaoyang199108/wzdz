package com.wzdz.entity;

/**
 * 权限管理
 * wzdz_tb_power
 * @author wudi
 *
 */
public class Power {
	
	private long id;
	private long pId;//父类id
	private String roleCode;//权限key
	private String roleName;//权限名称
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getpId() {
		return pId;
	}
	public void setpId(long pId) {
		this.pId = pId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
