package com.example.msaweatherdataeureka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.example.msaweatherdataeureka.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;




@Service
public class WeatherDataServiceImpl implements WeatherDataService{
	private final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private final String WEATHER_API="http://wthrcdn.etouch.cn/weather_mini";
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		String uri = WEATHER_API+"?citykey="+cityId;
		return this.doGetWeatherData(uri);
		
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		String uri = WEATHER_API + "?city="+cityName;
		return this.doGetWeatherData(uri);
	}
	//获取天气数据
	private WeatherResponse doGetWeatherData(String uri) {
		//先查缓存
		ValueOperations<String, String> ops = 
				this.stringRedisTemplate.opsForValue();
		String key = uri;
		String strBody = null;
		if(!this.stringRedisTemplate.hasKey(key)) {
			logger.error("不存在key:"+key);
			throw new RuntimeException("没有相应的天气数据");
		}else {
			logger.info("存在相应的key="+key+"value="+ops.get(key));
			strBody = ops.get(key);
		}
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse weather = null;
		try {
			weather = mapper.readValue(strBody, WeatherResponse.class);
		} catch (Exception e) {
			logger.error("JSON序列化异常!",e);
			throw new RuntimeException("天气解析失败!");
		}
		return weather;
	}
}
