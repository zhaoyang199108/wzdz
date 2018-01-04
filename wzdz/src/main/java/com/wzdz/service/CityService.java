package com.wzdz.service;

import com.wzdz.entity.City;

public interface CityService {

	City findAll();

	City findByTitleAndInformation(City city);


}
