package com.wzdz.service.BsznTypeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.BsznTypeDao;
import com.wzdz.entity.BsznType;
import com.wzdz.service.BsznTypeService;

@Service
public class bsznTypeServiceImpl implements BsznTypeService{

	@Autowired
	private BsznTypeDao bsznTypeDao;
	public List<BsznType> findAll() {
		
		return bsznTypeDao.findAll();
	}
	public void delete(String id) {
		bsznTypeDao.delete(id);
		
	}
	public int insert(BsznType bsznType) {
		return bsznTypeDao.insert(bsznType);
	}
	public int update(BsznType bsznType) {
		return bsznTypeDao.update(bsznType);
	}
	public List<BsznType> findByParentId(String id) {
		// TODO Auto-generated method stub
		return bsznTypeDao.findByParentId(id);
	}
	public BsznType findById(String id) {
		// TODO Auto-generated method stub
		return bsznTypeDao.findById(id);
	}

}
