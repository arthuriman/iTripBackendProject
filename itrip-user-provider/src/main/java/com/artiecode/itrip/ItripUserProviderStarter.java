package com.artiecode.itrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>用户模块项目Provider启动类</b>
 * @author Arthur
 * @version 4.0.0
 * @since 4.0.0
 */
@MapperScan("com.artiecode.itrip.dao")
@EnableEurekaClient
@SpringBootApplication
public class ItripUserProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripUserProviderStarter.class, args);
	}
}
