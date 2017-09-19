package com.lai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan    //开启自动扫描注解功能，将注解自动注册为bean

@EnableScheduling //启用定时任务的配置
public class Springboot5ExceptionHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot5ExceptionHandlerApplication.class, args);
	}
}
