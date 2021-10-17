package com.lin.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {

	public static void main(String[] args) {

		SpringApplication.run(CommunityApplication.class, args);
		//启动了Tomcat，创建了IOC容器
		//业务组件 用service 处理请求 用controller 数据库访问 用repository 通用 用component


	}

}
