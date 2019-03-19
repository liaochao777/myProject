package com.example.msaweatherreporteurekafeigngatewayhystrix.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.msaweatherreporteurekafeigngatewayhystrix.service.DataClient;
import com.example.msaweatherreporteurekafeigngatewayhystrix.service.WeatherReportService;
import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.City;






@RestController
@RequestMapping("/report")
public class WeatherReportController {
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);
	@Autowired
	private WeatherReportService weatherReportService;
	@Autowired
	private DataClient dataClient;
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId,Model model) {
		List<City> cityList = null;
		try {
			//调用其他feign的接口
			cityList = dataClient.listCity();
			
		} catch (Exception e) {
			logger.error("获取城市信息异常",e);
			throw new RuntimeException("获取城市信息异常",e);
		}
		model.addAttribute("title","大超的天气预报");
		model.addAttribute("cityId",cityId);
		model.addAttribute("cityList",cityList);
		model.addAttribute("report",weatherReportService.getDataByCityId(cityId));
		model.addAttribute("cityDetail",weatherReportService.getCityDetailByCityId(cityId));
		return new ModelAndView("weather/report","reportModel",model);
		
	}

}
