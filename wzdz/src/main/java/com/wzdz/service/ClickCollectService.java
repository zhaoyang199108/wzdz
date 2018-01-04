package com.wzdz.service;

import java.util.List;

import com.wzdz.entity.ClickCollect;

public interface ClickCollectService {

	ClickCollect findClick(String loginId, long typeId, String type);

	int insertIntoClick(ClickCollect cc);

	ClickCollect findCollect(String loginId, long typeId, String type);

	int insertIntoCollect(ClickCollect cc);

	int findSumClick(long id, String type);

	int findSumCollect(long id, String type);
	
	List<ClickCollect> findCollectList(String mobile,String type,int currentPage,int pageSize);
	
	List<ClickCollect> findChubbyCollectList(String mobile,String type,int currentPage,int pageSize);
	int cancelCollect(String mobile,String id);
	int cancelChubbyCollect(String mobile,String id);


}
