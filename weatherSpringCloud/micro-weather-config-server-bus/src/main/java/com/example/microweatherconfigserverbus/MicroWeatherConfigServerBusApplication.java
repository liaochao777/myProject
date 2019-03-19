package com.example.microweatherconfigserverbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class MicroWeatherConfigServerBusApplication {

	public static void main(String[] args) {
		System.out.println("SYSTEM RUNNING -------------");
		Long t1 = System.currentTimeMillis();
		SpringApplication.run(MicroWeatherConfigServerBusApplication.class, args);
		Long t2 = System.currentTimeMillis();
		Long t3 = (t2 - t1);
		System.out.println("系统启动，用时："+t3+"毫秒");
	}

}
