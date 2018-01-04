package com.wzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.Business;

public interface BusinessDao {
	List<Business> findBussinessByType(@Param("type") String type, @Param("currentPage")  int currentPage, @Param("pageSize")  int pageSize);
	List<Business> findBussinessByRecom(@Param("currentPage")  int currentPage, @Param("pageSize")  int pageSize);
	List<Business> findByType(@Param("id")  long id);
}
