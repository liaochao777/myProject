package com.example.msaweatherreporteurekafeigngatewayhystrix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.City;
import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.CityDetail;
import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.WeatherResponse;

@Component
public class DataClientFallback implements DataClient{
	/**
	 * 出错的时候就返回这两个写死的城市
	 */
	@Override
	public List<City> listCity() throws Exception {
		List<City> cityList = null;
		cityList = new ArrayList<>();
		City city = new City();
		city.setCityId("101270101");
		city.setCityName("成都");
		cityList.add(city);
		
		city = new City();
		city.setCityId("101030100");
		city.setCityName("天津");
		cityList.add(city);
		return cityList;
	}
	/**
	 * 出错的时候天气就返回这个  new WeatherResponse()   实际是null
	 */
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		
		return new WeatherResponse();
	}
	/**
	 * 当为获取到城市数据时的写死数据
	 */
	@Override
	public CityDetail getDetailInformation(String cityId) {
		
		return new CityDetail();
	}

}
