package com.wzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.ScenicPic;
import com.wzdz.entity.ScenicSpot;

public interface ScenicSpotDao {

	List<ScenicSpot> findByType(@Param("stauts") String stauts, @Param("currentPage")  int currentPage, @Param("pageSize")  int pageSize);

	ScenicSpot findByIdAndType(@Param("id") long id,@Param("stauts") String stauts);
	
    ScenicSpot findById(@Param("id")long id);
    
    List<ScenicPic> findPicBySSId(@Param("id")long id);

}
