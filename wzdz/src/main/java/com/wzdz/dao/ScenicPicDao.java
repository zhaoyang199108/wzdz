package com.wzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.ScenicPic;

public interface ScenicPicDao {
	 List<ScenicPic> findPicBySSId(@Param("id")long id);
}
