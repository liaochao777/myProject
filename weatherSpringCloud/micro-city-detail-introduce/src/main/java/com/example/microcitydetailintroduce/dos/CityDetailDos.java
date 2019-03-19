package com.example.microcitydetailintroduce.dos;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository("cityDetailDos")
public interface CityDetailDos {
	Map<String, String> queryCityDetail(String cityId);
}
