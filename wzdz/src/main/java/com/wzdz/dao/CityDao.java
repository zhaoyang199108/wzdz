package com.wzdz.dao;

import com.wzdz.entity.City;

public interface CityDao {

	City findAll();

	City findByTitleAndInformation(City city);

}
