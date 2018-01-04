package com.wzdz.service.TicketServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.TicketDao;
import com.wzdz.entity.ScenicSpot;
import com.wzdz.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private  TicketDao ticketDao;
	
	public List<ScenicSpot> findAll(int currentPage, int pageSize) {
		return ticketDao.findAll(currentPage,pageSize);
	}

	public List<ScenicSpot> findByArea(String area, int currentPage,int pageSize) {
		return ticketDao.findByArea(area,currentPage,pageSize);
	}

	public List<String> findList() {
		return ticketDao.findList();
	}

}
