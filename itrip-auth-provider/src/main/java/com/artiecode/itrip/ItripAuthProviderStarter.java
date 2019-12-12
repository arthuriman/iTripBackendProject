package com.artiecode.itrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>项目认证子项目Provider启动类</b>
 * @author Arthur
 * @version 3.1.0 2019-12-12
 * @since 3.1.0
 */
@EnableEurekaClient
@MapperScan("com.artiecode.itrip.dao")
@SpringBootApplication
public class ItripAuthProviderStarter {
    public static void main( String[] args ) {
        SpringApplication.run(ItripAuthProviderStarter.class, args);
    }
}
