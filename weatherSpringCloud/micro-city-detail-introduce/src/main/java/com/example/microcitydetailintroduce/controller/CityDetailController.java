package com.example.microcitydetailintroduce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microcitydetailintroduce.service.CityDetailInf;
import com.example.microcitydetailintroduce.vo.CityDetail;

@RequestMapping("/citiesDetail")
@RestController
public class CityDetailController {
	@Autowired
	private CityDetailInf cityDetailInf;
	@GetMapping("/cityId/{cityId}")
	public CityDetail getDetailInformation(@PathVariable("cityId") String cityId) {
		return cityDetailInf.getCityDetail(cityId);
	
	}
}
