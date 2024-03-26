package com.taoyiluo.springbootquickstarterrun;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//组合注解@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(
@SpringBootApplication
@ComponentScan(basePackages = {"com.taoyiluo","com.taoyiluo.springbootquickstarterservice"})
@MapperScan(basePackages = {"com.taoyiluo.springbootquickstarterservice.mapper"})
@Slf4j
public class SpringbootQuickstarterRunApplication {
	// 启动类
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootQuickstarterRunApplication.class, args);
		//引用了springboot-starter-web模块的DispatcherServlet
        //System.out.println(context.getBean(DispatcherServlet.class));
		System.out.println(context.getBean("dispatcherServlet"));
		log.info("项目启动成功");
		//获取bean，可以根据类，也可以根据name
		//UserMapper userMapper = context.getBean("UserMapper");
		//UserService userService = context.getBean(UserService.class);
	}
}
