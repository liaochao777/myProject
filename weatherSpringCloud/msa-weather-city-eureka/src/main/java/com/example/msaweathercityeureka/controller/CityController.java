package com.example.msaweathercityeureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.msaweathercityeureka.service.CityDataService;
import com.example.msaweathercityeureka.vo.City;



@RestController
@RequestMapping("/cities")
public class CityController {
	@Autowired
	private CityDataService cityDataService;
	@GetMapping
	public List<City> listCity() throws Exception{
		return cityDataService.listCity();
		
	}
}
