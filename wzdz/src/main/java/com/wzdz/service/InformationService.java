package com.wzdz.service;

import java.util.List;

import com.wzdz.entity.Information;

public interface InformationService {

	List<Information> findByType(String type, int currentPage,int pageSize);

	List<Information> findByAll();

	Information findById(long id);

}
