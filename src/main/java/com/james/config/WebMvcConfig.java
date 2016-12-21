package com.james.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by gaoji on 2016/11/05.
 */
@Configuration
@Import({DataBaseConfig.class})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    // spring session的配置
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        return jedisPoolConfig;
//	}
//
//    @Bean
//	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//		jedisConnectionFactory.setPort(6379);
//		jedisConnectionFactory.setHostName("localhost");
//		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
//		return jedisConnectionFactory;
//	}
//
//    @Bean
//    public StringRedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
//    	StringRedisTemplate redisTemplate = new StringRedisTemplate();
//    	redisTemplate.setConnectionFactory(jedisConnectionFactory);
//    	return redisTemplate;
//    }
//
//    @Bean
//    public RedisHttpSessionConfiguration redisHttpSessionConfiguration(JedisConnectionFactory jedisConnectionFactory) {
//        RedisHttpSessionConfiguration redisHttpSessionConfiguration = new RedisHttpSessionConfiguration();
//        redisHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(1800);
//        return redisHttpSessionConfiguration;
//    }
//
//    @Bean
//    public RedisOperationsSessionRepository sessionRepository(JedisConnectionFactory jedisConnectionFactory) {
//        RedisOperationsSessionRepository sessionRepository = new RedisOperationsSessionRepository(jedisConnectionFactory);
//        return sessionRepository;
//    }
//
//    @Bean
//    @SuppressWarnings("all")
//	public FilterRegistrationBean springSessionRepositoryFilter(RedisOperationsSessionRepository sessionRepository){
//		SessionRepositoryFilter springSessionRepositoryFilter=new SessionRepositoryFilter(sessionRepository);
//		FilterRegistrationBean registrationBean=new FilterRegistrationBean();
//		registrationBean.setFilter(springSessionRepositoryFilter);
//		List<String> urlPatterns=new ArrayList<String>();
//		urlPatterns.add("/*");//拦截路径，可以添加多个
//		registrationBean.setUrlPatterns(urlPatterns);
//		registrationBean.setOrder(1);
//		return registrationBean;
//	}
}
