package com.wzdz.service.BusinessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.BusinessDao;
import com.wzdz.entity.Business;
import com.wzdz.service.BusinessService;
@Service
public class BuesinessServiceImpl implements BusinessService {
	@Autowired
	private  BusinessDao businessDao;
	public List<Business> findBussinessByType(String type,int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return businessDao.findBussinessByType(type,currentPage,pageSize);
	}
	public List<Business> findBussinessByRecom(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return businessDao.findBussinessByRecom(currentPage,pageSize);
	}
	public List<Business> findByType(long id) {
		return businessDao.findByType(id);
	}

}
