package com.taoyiluo.springbootquickstarterrun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.taoyiluo")
@ComponentScan(basePackages = {"com.taoyiluo"})
@Slf4j
public class SpringbootQuickstarterRunApplication {
	// 启动类
	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuickstarterRunApplication.class, args);
		log.info("项目启动成功");
	}
}
