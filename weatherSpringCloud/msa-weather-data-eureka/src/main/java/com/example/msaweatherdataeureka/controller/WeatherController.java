package com.example.msaweatherdataeureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.msaweatherdataeureka.service.WeatherDataService;
import com.example.msaweatherdataeureka.vo.WeatherResponse;



@RestController
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	private WeatherDataService weatherDataService;
	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId) {
		WeatherResponse response = weatherDataService.getDataByCityId(cityId);
		return response;
		
	}
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
		
	}
}
