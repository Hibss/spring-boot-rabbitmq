package com.steven;

import com.steven.filter.ThreadInformationFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author steven.sheng
 */
@SpringBootApplication
@MapperScan("com.steven.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public FilterRegistrationBean requestFilter(){
		FilterRegistrationBean bean = new FilterRegistrationBean(new ThreadInformationFilter());
		bean.addUrlPatterns("/*");
		bean.setName("threadFilter");
		bean.setOrder(1);
		return bean;
	}
}
