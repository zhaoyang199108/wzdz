package com.wzdz.service;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.TrafficCon;

public interface TrafficConService {

	TrafficCon findAll();
	TrafficCon findById(String id);
	int update(TrafficCon trafficCon);



}
