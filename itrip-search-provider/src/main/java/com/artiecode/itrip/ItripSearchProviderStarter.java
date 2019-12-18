package com.artiecode.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>搜索模块Provider启动类</b>
 * @author Arthur
 * @version 3.1.1
 * @since 3.1.1
 */
@EnableEurekaClient
@SpringBootApplication
public class ItripSearchProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripSearchProviderStarter.class, args);
	}
}
