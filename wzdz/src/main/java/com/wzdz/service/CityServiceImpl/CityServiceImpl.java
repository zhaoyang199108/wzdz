package com.wzdz.service.CityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.CityDao;
import com.wzdz.entity.City;
import com.wzdz.service.CityService;

@Service
public class CityServiceImpl  implements CityService{
	
	
	@Autowired
	private  CityDao cityDao;
	
	public City findAll() {
		return cityDao.findAll();
	}

	public City findByTitleAndInformation(City city) {
		return cityDao.findByTitleAndInformation(city);
	}
	
	

}
