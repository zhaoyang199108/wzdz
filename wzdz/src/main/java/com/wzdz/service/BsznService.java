package com.wzdz.service;


import java.util.List;

import com.wzdz.entity.Bszn;

public interface BsznService {

	List<Bszn> findAll(int pageNum,int pageSize);
	Bszn findById(String id);
	int insert(Bszn bszn);
	int update(Bszn bszn);
	void delete(String id);
	List<Bszn> findByType(String type,String keyword,int pageNum,int pageSize);
	int findCount(String type);

}
