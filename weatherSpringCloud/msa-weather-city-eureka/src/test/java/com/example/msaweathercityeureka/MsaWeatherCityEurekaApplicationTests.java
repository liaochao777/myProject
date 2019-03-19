package com.example.msaweathercityeureka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsaWeatherCityEurekaApplicationTests {
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${server.port}")
	private String port;
	@Test
	public void contextLoads() {
		System.out.println(applicationName+""+port);
		
	}

}
