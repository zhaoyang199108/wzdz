package com.wzdz.service;

import java.util.List;

import com.wzdz.entity.CityFeature;


public interface CityFeatureService {


	List<CityFeature> findByIdAndType( String type, int currentPage,int pageSize);

	CityFeature findById(long id, String type);

	

}
