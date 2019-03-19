package com.example.msaweatherreporteurekafeigngatewayhystrix.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.City;
import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.CityDetail;
import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.WeatherResponse;



@FeignClient(name="msa-weather-eureka-client-zuul",fallback=DataClientFallback.class)
public interface DataClient {
	/**
	 * 获取城市列表
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;
	/**
	 * 根据城市获取天气数据
	 * @param cityId
	 * @return
	 */
	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
	/**
	 * 根据城市Id获取城市相关数据
	 * @param cityId
	 * @return
	 */
	@GetMapping("/cityDetail/citiesDetail/cityId/{cityId}")
	CityDetail getDetailInformation(@PathVariable("cityId") String cityId);
}
