package com.wzdz.service.ScenicSpotServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.ScenicPicDao;
import com.wzdz.dao.ScenicSpotDao;
import com.wzdz.entity.ScenicPic;
import com.wzdz.entity.ScenicSpot;
import com.wzdz.service.ScenicSpotService;

@Service
public class ScenicSpotServiceImpl implements ScenicSpotService{

	@Autowired
	private  ScenicSpotDao scenicSpotDao;
	@Autowired
	private ScenicPicDao scenicPicDao;
	
	public List<ScenicSpot> findByType(String stauts, int currentPage,
			int pageSize) {
		return scenicSpotDao.findByType(stauts,currentPage,pageSize);
	}

	public ScenicSpot findByIdAndType(long id,String stauts) {
		return scenicSpotDao.findByIdAndType(id,stauts);
	}

	public ScenicSpot findById(long id) {
		// TODO Auto-generated method stub
		return scenicSpotDao.findById(id);
	}

	public List<ScenicPic> findPicBySSId(long id) {
		// TODO Auto-generated method stub
		return scenicPicDao.findPicBySSId(id);
	}
	
	

}
