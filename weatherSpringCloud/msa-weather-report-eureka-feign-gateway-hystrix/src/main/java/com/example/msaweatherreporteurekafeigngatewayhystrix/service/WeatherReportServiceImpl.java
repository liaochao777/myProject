package com.example.msaweatherreporteurekafeigngatewayhystrix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.CityDetail;
import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.Weather;
import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.WeatherResponse;



@Service
public class WeatherReportServiceImpl implements WeatherReportService{
	@Autowired
	private DataClient dataClient;
	@Override
	public Weather getDataByCityId(String cityId) {
		
		//通过feign接口来调用其他微服务
		WeatherResponse response = dataClient.getDataByCityId(cityId);
		return response.getData();
	}
	@Override
	public CityDetail getCityDetailByCityId(String cityId) {
		CityDetail cityDetail = dataClient.getDetailInformation(cityId);
		return cityDetail;
	}

}
