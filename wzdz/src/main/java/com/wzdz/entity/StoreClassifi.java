package com.wzdz.entity;

/**
 * 店铺分类
 * wzdz_tb_store_classifi
 * @author wudi
 *
 */
public class StoreClassifi {
	
	private long id;
	private long detailId;//类型详细id
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDetailId() {
		return detailId;
	}
	public void setDetailId(long detailId) {
		this.detailId = detailId;
	}
	

}
