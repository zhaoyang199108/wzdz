package com.wzdz.service.ClickCollectServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.ClickCollectDao;
import com.wzdz.entity.ClickCollect;
import com.wzdz.service.ClickCollectService;

@Service
public class ClickCollectServiceImpl implements ClickCollectService{

	@Autowired
	private ClickCollectDao clickCollectDao;
	
	public ClickCollect findClick(String loginId, long typeId, String type) {
		return clickCollectDao.findClick(loginId,typeId,type);
	}

	public int insertIntoClick(ClickCollect cc) {
		int count = clickCollectDao.insertIntoClick(cc);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public ClickCollect findCollect(String loginId, long typeId, String type) {
		return clickCollectDao.findCollect(loginId,typeId,type);
	}

	public int insertIntoCollect(ClickCollect cc) {
		int count = clickCollectDao.insertIntoCollect(cc);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public int findSumClick(long id, String type) {
		return clickCollectDao.findSumClick(id,type);
	}

	public int findSumCollect(long id, String type) {
		return clickCollectDao.findSumCollect(id,type);
	}

	public List<ClickCollect> findCollectList(String mobile, String type,int currentPage,int pageSize) {
		// TODO Auto-generated method stub
		return clickCollectDao.findCollectList(mobile,type,currentPage,pageSize);
	}

	public List<ClickCollect> findChubbyCollectList(String mobile, String type,
			int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return clickCollectDao.findChubbyCollectList(mobile,type,currentPage,pageSize);
	}

	public int cancelCollect(String mobile, String id) {
		// TODO Auto-generated method stub
		return clickCollectDao.cancelCollect(mobile,id);
	}

	public int cancelChubbyCollect(String mobile, String id) {
		// TODO Auto-generated method stub
		return clickCollectDao.cancelChubbyCollect(mobile,id);
	}
	

}
