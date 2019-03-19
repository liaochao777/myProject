package com.example.msaweatherdataeureka.service;

import com.example.msaweatherdataeureka.vo.WeatherResponse;

public interface WeatherDataService {
	/**
	 * 根据城市Id查询天气
	 * @param cityId
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);
	/**
	 * 根据城市名称查询天气
	 * @param cityName
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);
}
