package com.artiecode.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>iTrip项目注册中心Eureka Server启动类</b>
 * @author Arthur
 * @version 3.1.0 2019-12-11
 * @since 3.1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class ItripEurekaServerStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripEurekaServerStarter.class, args);
	}
}
