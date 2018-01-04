package com.wzdz.service;

import java.util.List;

import com.wzdz.entity.Chubby;

public interface ChubbyService {

	List<Chubby> findByAll(int currentPage, int pageSize);

	Chubby findById(long id);

}
