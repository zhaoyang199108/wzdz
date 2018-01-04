package com.wzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.ClickCollect;

public interface ClickCollectDao {

	ClickCollect findClick( @Param("loginId") String loginId,  @Param("typeId") long typeId,  @Param("type") String type);

	int insertIntoClick(ClickCollect cc);

	ClickCollect findCollect( @Param("loginId") String loginId,  @Param("typeId") long typeId,  @Param("type") String type);

	int insertIntoCollect(ClickCollect cc);

	int findSumClick(@Param("id") long id, @Param("type")  String type);

	int findSumCollect(@Param("id")  long id, @Param("type")  String type);
	
	List<ClickCollect> findCollectList(@Param("mobile") String mobile,@Param("type") String type, @Param("currentPage")  int currentPage, @Param("pageSize")  int pageSize);
	List<ClickCollect> findChubbyCollectList(@Param("mobile") String mobile,@Param("type") String type, @Param("currentPage")  int currentPage, @Param("pageSize")  int pageSize);
	
	int cancelCollect(@Param("mobile") String mobile,@Param("id") String id);
	int cancelChubbyCollect(@Param("mobile") String mobile,@Param("id") String id);
}
