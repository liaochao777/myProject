package com.example.microweathereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroWeatherEurekaServerApplication {

	public static void main(String[] args) {
		System.out.println("SYSTEM RUNNING -------------");
		Long t1 = System.currentTimeMillis();
		SpringApplication.run(MicroWeatherEurekaServerApplication.class, args);
		Long t2 = System.currentTimeMillis();
		Long t3 = (t2 - t1);
		System.out.println("系统启动，用时："+t3+"毫秒");
	}

}
