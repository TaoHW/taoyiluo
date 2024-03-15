package com.taoyiluo.springbootquickstarterapi.config.redisConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * @author Taohw
 * @Classname RedisConfig
 * @Description TODO
 * @Date 2024/3/8 14:07
 * @Version V1.0
 */
@Configuration
public class RedisConfig {
	/**
	 * RedisTemplate模板
	 */
	//注入对象的默认名字是方法名
	//如果方法的内部需要使用ioc容器中存在的bean对象，那么只要在方法上声明，spring会自动注入
	@Bean("redisTemplate")
	@SuppressWarnings("all")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}

	/**
	 * StringRedisTemplate模板
	 */
	@Bean
	@SuppressWarnings("all")
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(factory);
		stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
		return stringRedisTemplate;
	}

	/**
	 * Redis分布式锁
	 */
	@Bean
	@SuppressWarnings("all")
	public RedisLockRegistry redisLockRegistry(RedisConnectionFactory factory){
		// 1、锁的密钥前缀：REDIS-LOCK
		// 2、锁的过期时间：20秒
		return new RedisLockRegistry(factory, "REDIS-LOCK",20000L);
	}
}