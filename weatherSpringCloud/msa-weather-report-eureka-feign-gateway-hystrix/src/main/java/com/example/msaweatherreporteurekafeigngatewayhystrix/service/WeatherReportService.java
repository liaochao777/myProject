package com.example.msaweatherreporteurekafeigngatewayhystrix.service;

import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.CityDetail;
import com.example.msaweatherreporteurekafeigngatewayhystrix.vo.Weather;

public interface WeatherReportService {
	Weather getDataByCityId(String cityId);
	CityDetail getCityDetailByCityId(String cityId);
}
