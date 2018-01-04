package com.wzdz.dao;


import java.util.List;

import com.wzdz.entity.BsznType;



public interface BsznTypeDao {

	List<BsznType>  findAll();
	void delete(String id);
	int insert(BsznType bsznType);
	int update(BsznType bsznType);
	List<BsznType> findByParentId(String id);
	BsznType findById(String id);
	

}
