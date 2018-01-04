package com.wzdz.service.InformationServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.InformationDao;
import com.wzdz.entity.Information;
import com.wzdz.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService{

	@Autowired
	private InformationDao informationDao;
	
	
	public List<Information> findByType(String type, int currentPage,
			int pageSize) {
		return informationDao.findByType(type,currentPage,pageSize);
	}


	public List<Information> findByAll() {
		return informationDao.findByAll();
	}


	public Information findById(long id) {
		return informationDao.findById(id);
	}
	

}
