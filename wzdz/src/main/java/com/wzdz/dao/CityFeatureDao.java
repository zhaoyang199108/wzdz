package com.wzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.CityFeature;


public interface CityFeatureDao {
	List<CityFeature> findByIdAndType(@Param("type") String type,
			 @Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

	CityFeature findById(@Param("id")  long id, @Param("type")  String type);
}
