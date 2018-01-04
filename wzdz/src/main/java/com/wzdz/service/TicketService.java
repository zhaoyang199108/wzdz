package com.wzdz.service;

import java.util.List;

import com.wzdz.entity.ScenicSpot;

public interface TicketService {

	List<ScenicSpot> findAll(int currentPage, int pageSize);

	List<ScenicSpot> findByArea(String area, int currentPage, int pageSize);

	List<String> findList();

}
