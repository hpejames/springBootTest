package com.james.config;

import java.io.IOException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.james.page.PostgreSqlPagingInterceptor;

@Configuration
public class DataBaseConfig {
    @Bean
    public BasicDataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.postgresql.Driver");
    	dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?currentSchema=public");
    	dataSource.setUsername("postgres");
    	dataSource.setPassword("gaojian123");
    	dataSource.setMaxActive(50);
    	dataSource.setMaxIdle(10);
    	dataSource.setMaxWait(3000);
    	return dataSource;
    }

   @Bean
   public DataSourceTransactionManager transactionManager(BasicDataSource dataSource) {
	   DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
	   transactionManager.setDataSource(dataSource);
	   return transactionManager;
	   
   }

   @Bean
   public PostgreSqlPagingInterceptor postgreSqlPagingInterceptor() {
	   PostgreSqlPagingInterceptor postgreSqlPagingInterceptor = new PostgreSqlPagingInterceptor();
	   return postgreSqlPagingInterceptor;
   }

   @Bean
   public SqlSessionFactoryBean sqlSessionFactory(BasicDataSource dataSource, PostgreSqlPagingInterceptor postgreSqlPagingInterceptor) throws IOException {
	   SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	   sqlSessionFactory.setDataSource(dataSource);
	   sqlSessionFactory.setTypeAliasesPackage("com.james.model");
	   PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	   sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:com/james/mapper/xml/*.xml"));
	   Interceptor[] plugins = new Interceptor[] {postgreSqlPagingInterceptor};
	   sqlSessionFactory.setPlugins(plugins);
	   return sqlSessionFactory;
   }

   @Bean
   public MapperScannerConfigurer mapperScannerConfigurer() {
	   MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
	   mapperScannerConfigurer.setBasePackage("com.james.mapper");
	   mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
	   return mapperScannerConfigurer;
   }
}
