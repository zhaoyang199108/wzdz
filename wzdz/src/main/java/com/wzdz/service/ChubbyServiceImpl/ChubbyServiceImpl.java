package com.wzdz.service.ChubbyServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.ChubbyDao;
import com.wzdz.entity.Chubby;
import com.wzdz.service.ChubbyService;

@Service
public class ChubbyServiceImpl implements ChubbyService{

	
	@Autowired
	private  ChubbyDao chubbyDao;
	
	public List<Chubby> findByAll(int currentPage, int pageSize) {
		return chubbyDao.findByAll(currentPage,pageSize);
	}

	public Chubby findById(long id) {
		return chubbyDao.findById(id);
	}
	
	
	
	

	
}
