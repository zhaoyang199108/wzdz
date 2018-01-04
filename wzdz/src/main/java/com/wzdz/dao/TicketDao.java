package com.wzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.ScenicSpot;

public interface TicketDao {

	List<ScenicSpot> findAll(@Param("currentPage")   int currentPage, @Param("pageSize")   int pageSize);

	List<ScenicSpot> findByArea(@Param("area") String area, @Param("currentPage") int currentPage,@Param("pageSize") int pageSize);

	List<String> findList();

}
