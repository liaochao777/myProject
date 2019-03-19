package com.example.msaweathercollectioneurekafeign.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.msaweathercollectioneurekafeign.job.WeatherDataSyncJob;




@Configuration
public class QuartzConfiguration {
	
	private final int TIME = 1800;//更新频率
	
	@Bean
	public JobDetail weatherDataSycJobDetail() {
		
		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
				.storeDurably().build();
	}
	
	@Bean
	public Trigger sampleJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(TIME).repeatForever();
		return TriggerBuilder.newTrigger().forJob(weatherDataSycJobDetail())
				.withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
		
	}
}
