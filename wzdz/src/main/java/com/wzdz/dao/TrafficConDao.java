package com.wzdz.dao;

import org.apache.ibatis.annotations.Param;

import com.wzdz.entity.TrafficCon;



public interface TrafficConDao {

	TrafficCon findAll();
	TrafficCon findById(@Param("id")String id);
	int update(TrafficCon trafficCon);
	

}
