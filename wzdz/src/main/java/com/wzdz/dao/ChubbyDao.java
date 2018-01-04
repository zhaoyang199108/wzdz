package com.wzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.Chubby;

public interface ChubbyDao {

	List<Chubby> findByAll(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

	Chubby findById(long id);
	

}
