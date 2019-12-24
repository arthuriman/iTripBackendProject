package com.artiecode.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>酒店子项目Consumer启动类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ItripHotelConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripHotelConsumerStarter.class, args);
	}
}
