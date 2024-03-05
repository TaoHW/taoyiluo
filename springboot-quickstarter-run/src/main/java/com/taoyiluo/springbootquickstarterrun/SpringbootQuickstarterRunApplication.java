package com.taoyiluo.springbootquickstarterrun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.taoyiluo"})
public class SpringbootQuickstarterRunApplication {
	// 启动类
	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuickstarterRunApplication.class, args);
		System.out.println("启动成功！");
	}
}
