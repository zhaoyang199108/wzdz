package com.wzdz.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.Bszn;



public interface BsznDao {

	List<Bszn>  findAll(@Param(value="pageNum")int pageNum,@Param(value="pageSize")int pageSize);
	Bszn findById(String id);
	int insert(Bszn bszn);
	int update(Bszn bszn);
	void delete(String id);
	List<Bszn> findByType(@Param(value="type")String type,@Param(value="keyword")String keyword ,@Param(value="pageNum")int pageNum,@Param(value="pageSize")int pageSize);
	int findCount(String type);

}
