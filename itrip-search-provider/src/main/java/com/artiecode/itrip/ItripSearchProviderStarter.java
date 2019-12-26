package com.artiecode.itrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>搜索模块Provider</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@MapperScan("com.articode.itrip.dao")
@EnableEurekaClient
@SpringBootApplication
public class ItripSearchProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripSearchProviderStarter.class, args);
	}
}
