package com.example.msaweathercityeureka.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.tomcat.jni.Buffer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.msaweathercityeureka.util.XmlBuilder;
import com.example.msaweathercityeureka.vo.City;
import com.example.msaweathercityeureka.vo.CityList;


@Service
public class CityDataServiceImpl implements CityDataService{

	@Override
	public List<City> listCity() throws Exception {
		ClassPathResource resource =  new ClassPathResource("citylist.xml");
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while((line=br.readLine())!=null) {
			buffer.append(line);
		}
		br.close();
		CityList cityList = (CityList)XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
		return cityList.getCityList();
	}

}
