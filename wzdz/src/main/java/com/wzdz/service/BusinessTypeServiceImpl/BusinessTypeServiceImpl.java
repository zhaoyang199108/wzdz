package com.wzdz.service.BusinessTypeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.BusinessTypeDao;
import com.wzdz.entity.BusinessType;
import com.wzdz.service.BusinessTypeService;

@Service
public class BusinessTypeServiceImpl  implements BusinessTypeService{

	@Autowired
	private  BusinessTypeDao businessTypeDao;

	public List<BusinessType> findAll() {
		return businessTypeDao.findAll();
	}

	
}
