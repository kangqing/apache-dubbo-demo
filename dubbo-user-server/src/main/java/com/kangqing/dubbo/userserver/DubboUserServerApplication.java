package com.kangqing.dubbo.userserver;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@MapperScan("com.kangqing.dubbo.mapper")
@SpringBootApplication
public class DubboUserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboUserServerApplication.class, args);
	}

}
