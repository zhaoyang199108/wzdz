package com.wzdz.service.BsznServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.BsznDao;
import com.wzdz.entity.Bszn;
import com.wzdz.service.BsznService;

@Service
public class BsznServiceImpl implements BsznService {

	@Autowired
	private BsznDao bsznDao;
	
	public Bszn findById(String id) {
		// TODO Auto-generated method stub
		return bsznDao.findById(id);
	}
	public int insert(Bszn bszn) {
		// TODO Auto-generated method stub
		return bsznDao.insert(bszn);
	}
	public int update(Bszn bszn) {
		// TODO Auto-generated method stub
		return bsznDao.update(bszn);
	}
	public void delete(String id) {
		// TODO Auto-generated method stub
		bsznDao.delete(id);
	}
	public List<Bszn> findByType(String type,String keyword ,int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return bsznDao.findByType(type,keyword,pageNum, pageSize);
	}
	public List<Bszn> findAll(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return bsznDao.findAll(pageNum, pageSize);
	}
	public int findCount(String type) {
		// TODO Auto-generated method stub
		return bsznDao.findCount(type);
	}

}
