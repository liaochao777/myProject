package com.example.msaweathercityeureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class VersionController {
	/**
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/config")
	public String getConfig() {
		System.out.println(applicationName+""+port);
		return applicationName+""+port;
		
	}
	*/
}
