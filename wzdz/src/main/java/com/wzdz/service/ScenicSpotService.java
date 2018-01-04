package com.wzdz.service;

import java.util.List;

import com.wzdz.entity.ScenicPic;
import com.wzdz.entity.ScenicSpot;

public interface ScenicSpotService {

	List<ScenicSpot> findByType(String stauts, int currentPage, int pageSize);

	ScenicSpot findByIdAndType(long id, String stauts);
	
	ScenicSpot findById(long id);
	
	List<ScenicPic> findPicBySSId(long id);

}
