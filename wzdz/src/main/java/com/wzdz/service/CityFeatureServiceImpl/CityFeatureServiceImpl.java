package com.wzdz.service.CityFeatureServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.CityFeatureDao;
import com.wzdz.entity.CityFeature;
import com.wzdz.service.CityFeatureService;

@Service
public class CityFeatureServiceImpl implements CityFeatureService{

	@Autowired
	private  CityFeatureDao cityFeatureDao;

	public List<CityFeature> findByIdAndType(String type,
			int currentPage, int pageSize) {
		return cityFeatureDao.findByIdAndType(type,currentPage,pageSize);
	}

	public CityFeature findById(long id, String type) {
		return cityFeatureDao.findById(id,type);
	}

}
