package com.example.msaweathercollectioneurekafeign.service;

public interface WeatherDataCollectionService {

	void syncDataByCity(String cityId);
}
