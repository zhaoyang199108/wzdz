package com.wzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.Information;

public interface InformationDao {

	List<Information> findByType(@Param("type") String type, @Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

	List<Information> findByAll();

	Information findById(@Param("id")  long id);
	
}
