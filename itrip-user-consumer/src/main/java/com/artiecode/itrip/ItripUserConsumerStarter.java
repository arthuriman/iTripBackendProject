package com.artiecode.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>用户模块项目Consumer启动类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ItripUserConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripUserConsumerStarter.class, args);
	}
}
