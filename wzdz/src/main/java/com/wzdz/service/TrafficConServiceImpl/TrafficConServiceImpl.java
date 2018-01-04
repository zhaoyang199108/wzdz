package com.wzdz.service.TrafficConServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.TrafficConDao;
import com.wzdz.entity.TrafficCon;
import com.wzdz.service.TrafficConService;

@Service
public class TrafficConServiceImpl  implements TrafficConService{
	
	
	@Autowired
	private  TrafficConDao trafficConDao;
	
	public TrafficCon findAll() {
		return trafficConDao.findAll();
	}

	public int update(TrafficCon trafficCon) {
		
		return trafficConDao.update(trafficCon);
	}

	public TrafficCon findById(String id) {
		
		return trafficConDao.findById(id);
	}

	
	
	

}
