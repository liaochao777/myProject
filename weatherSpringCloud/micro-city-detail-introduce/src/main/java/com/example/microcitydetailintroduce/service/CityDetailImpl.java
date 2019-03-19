package com.example.microcitydetailintroduce.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.bouncycastle.jcajce.spec.MQVParameterSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microcitydetailintroduce.dos.CityDetailDos;
import com.example.microcitydetailintroduce.vo.CityDetail;
@Service
public class CityDetailImpl implements CityDetailInf{
	@Resource(name="cityDetailDos")
	private CityDetailDos cityDetailDos;

	@Override
	public CityDetail getCityDetail(String cityId) {
		Map<String, String> map = new HashMap<String,String>();
		map = cityDetailDos.queryCityDetail(cityId);
		CityDetail mycity = new CityDetail();
		mycity.setCityName(map.get("cityName"));
		mycity.setCityId((map.get("cityId")));
		mycity.setCityLevel(map.get("cityLevel"));
		mycity.setCityDescrible(map.get("cityDescrible"));
		mycity.setCityFood(map.get("cityFood"));
		mycity.setCityViewPoint(map.get("cityViewPoint"));
		mycity.setCitybeautiIndex(map.get("beautyIndex"));
		
		return mycity;
	}

}
