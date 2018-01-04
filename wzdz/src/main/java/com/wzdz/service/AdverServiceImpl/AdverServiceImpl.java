package com.wzdz.service.AdverServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.AdverDao;
import com.wzdz.entity.Adver;
import com.wzdz.service.AdverService;

@Service
public class AdverServiceImpl implements AdverService {

	
	@Autowired
	private  AdverDao adverDao;
	
	public List<Adver> findByAll() {
		return adverDao.findByAll();
	}

}
