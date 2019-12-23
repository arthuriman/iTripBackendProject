package com.artiecode.itrip.base.configuartion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ExecutorConfiguration {

	@Bean
	public Executor asyncServieExecutor() {
		// 创建能够执行异步操作的线程对象
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// 配置核心线程数
		executor.setCorePoolSize(5);
		// 配置最大线程数
		executor.setMaxPoolSize(15);
		// 配置线程中的队列大小
		executor.setQueueCapacity(10000);
		// 配置线程中线程的前缀
		executor.setThreadNamePrefix("itrip-");

		// 初始化
		executor.initialize();
		return executor;
	}
}
