package com.example.msaweathercollectioneurekafeign.job;

import java.util.ArrayList;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.example.msaweathercollectioneurekafeign.service.CityClient;
import com.example.msaweathercollectioneurekafeign.service.WeatherDataCollectionService;
import com.example.msaweathercollectioneurekafeign.vo.City;





public class WeatherDataSyncJob extends QuartzJobBean{
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	
	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	@Autowired
	private CityClient cityClient;
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Start 天气数据同步");
		List<City> cityList = null;
		try {
			//这个是通过feign功能调用其他微服务的接口
			cityList = cityClient.listCity();
			
		} catch (Exception e) {
			logger.info("获取城市信息失败!");
			throw new RuntimeException("获取城市信息异常!",e);
		}
		for(City city:cityList) {
			String cityId = city.getCityId();
			logger.info("天气数据同步中,cityId:"+cityId);
			weatherDataCollectionService.syncDataByCity(cityId);
		}
		logger.info("End 天气数据同步完成!");
	}

}
