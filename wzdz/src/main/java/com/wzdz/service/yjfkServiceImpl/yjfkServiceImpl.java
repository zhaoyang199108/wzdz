package com.wzdz.service.yjfkServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.YjfkDao;
import com.wzdz.entity.Yjfk;
import com.wzdz.service.YjfkService;
@Service
public class yjfkServiceImpl implements YjfkService {
	private @Autowired YjfkDao yjfkDao;
	public int insertIntoYjfk(Yjfk yjfk) {
		// TODO Auto-generated method stub
		return yjfkDao.insertIntoYjfk(yjfk);
	}

}
