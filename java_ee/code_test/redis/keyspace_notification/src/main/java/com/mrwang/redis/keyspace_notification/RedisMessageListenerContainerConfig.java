package com.mrwang.redis.keyspace_notification;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
 
@Configuration
public class RedisMessageListenerContainerConfig {
	
	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;
	
	@Autowired
	private TopicMessageListener messageListener;
	
	@Autowired
	private TaskThreadPoolConfig config;
	
	@Value("spring.redis.topic")
	private String topic;
	
	@Bean
	public RedisMessageListenerContainer configRedisMessageListenerContainer(Executor executor){
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		// 设置Redis的连接工厂
		container.setConnectionFactory(redisTemplate.getConnectionFactory());
		// 设置监听使用的线程池
		container.setTaskExecutor(executor);
		// 设置监听的Topic
		ChannelTopic channelTopic = new ChannelTopic("__keyevent@0__:expired");
		// 设置监听器
		container.addMessageListener(messageListener, channelTopic);
		return container;
	}
	
	@Bean // 配置线程池
	public Executor myTaskAsyncPool() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(config.getCorePoolSize());
		executor.setMaxPoolSize(config.getMaxPoolSize());
		executor.setQueueCapacity(config.getQueueCapacity());
		executor.setKeepAliveSeconds(config.getKeepAliveSeconds());
		executor.setThreadNamePrefix(config.getThreadNamePrefix());
 
		// rejection-policy：当pool已经达到max size的时候，如何处理新任务
		// CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return executor;
	}
}