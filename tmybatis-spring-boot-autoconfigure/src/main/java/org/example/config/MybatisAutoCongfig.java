package org.example.config;

import jodd.introspector.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Taohw
 * @Classname MybatisAutoCongfig
 * @Description TODO
 * @Date 2024/3/18 15:27
 * @Version V1.0
 */
@AutoConfiguration//表示当前类是一个自动配置类
public class MybatisAutoCongfig {

	//SqlSessionFactoryBean这个类在springboot启动的时候会自动加载
    //这个类里面会自动配置mybatis的一些东西
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}

	//MapperScannerConfigurer这个类在springboot启动的时候会自动加载
    //这个类里面会自动配置mybatis的一些东西
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(BeanFactory beanFactory){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		//扫描的包：启动类所在的包及其子包
		List<String> packages = AutoConfigurationPackages.get(beanFactory);
		String p = packages.get(0);
		mapperScannerConfigurer.setBasePackage(p);

		//扫描的注解
		mapperScannerConfigurer.setAnnotationClass(Mapper.class);
		return mapperScannerConfigurer;
	}
}
