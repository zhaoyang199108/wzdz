package com.wzdz.service;

import java.util.List;

import com.wzdz.entity.Business;

public interface BusinessService {
	List<Business> findBussinessByType(String type,int currentPage, int pageSize);
	List<Business> findBussinessByRecom(int currentPage, int pageSize);
	List<Business> findByType(long id);
}
