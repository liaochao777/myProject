package com.example.msaweathercollectioneurekafeign.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.msaweathercollectioneurekafeign.vo.City;

@FeignClient("msa-weather-city-eureka")
public interface CityClient {
	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
