package com.swust.fund.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ThreadPoolConfig
 * @Package com.swust.fund.config
 * @description: 线程池配置
 * @date 2019/9/19 10:14
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    @Bean("threadPool")
    public ThreadPoolTaskExecutor ThreadPoolTaskExecutorMyTaskAsyncPool() {
        // 创建线程池
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置常用线程数
        executor.setCorePoolSize(5);
        // 设置最大线程数
        executor.setMaxPoolSize(10);
        // 设置队列容量
        executor.setQueueCapacity(100);
        // 设置线程名前缀
        executor.setThreadNamePrefix("Pool-");
        // 设置拒绝执行处理程序(具体参数意思？)
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 线程池初始化
        executor.initialize();
        // 得到线程池
        return executor;

    }
}
