package com.example.msaweathercollectioneurekafeign.service;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author Admin
 *天气采集服务：从给定接口采集天气数据，存入redis
 *
 *
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService{
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private final String WEATHER_API="http://wthrcdn.etouch.cn/weather_mini";
	
	private final Long TIME_OUT = 1800L;
	@Override
	public void syncDataByCity(String cityId) {
		logger.info("Start 同步天气cityId:"+cityId);
		
		String uri = WEATHER_API+"?citykey="+cityId;
		this.saveWeatherData(uri);
		
		logger.info("End 同步天气");
	}
	private void saveWeatherData(String uri) throws NestedRuntimeException {
		ValueOperations<String, String> ops = 
				this.stringRedisTemplate.opsForValue();
		
		String key = uri;
		String strBody = null;
		
		ResponseEntity<String> response;
		
			response = restTemplate.getForEntity(uri, String.class);
		
		
		if (response.getStatusCode().value() == 200) {
			strBody = response.getBody();
		}
		ops.set(key, strBody,TIME_OUT,TimeUnit.SECONDS);
		
	}

}
