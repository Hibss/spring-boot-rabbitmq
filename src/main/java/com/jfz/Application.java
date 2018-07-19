package com.jfz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author steven.sheng
 */
@SpringBootApplication
@MapperScan("com.jfz.mapper")
//@ComponentScan("com.jfz.service")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
