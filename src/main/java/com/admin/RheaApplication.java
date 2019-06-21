package com.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.admin.common.SocketUtil;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@MapperScan("com.admin.dao")
public class RheaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RheaApplication.class, args);
		new SocketUtil().start();
	}

}
