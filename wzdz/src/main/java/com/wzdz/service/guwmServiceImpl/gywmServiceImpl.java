package com.wzdz.service.guwmServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.GywmDao;
import com.wzdz.entity.Gywm;
import com.wzdz.service.GywmService;
@Service
public class gywmServiceImpl implements GywmService {
	private @Autowired GywmDao gywmDao;
	public Gywm findGywm() {
		// TODO Auto-generated method stub
		return gywmDao.findGywm();
	}

}
