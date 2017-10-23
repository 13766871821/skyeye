package com.hfax.openplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableTransactionManagement
@Configuration
@MapperScan("com.hfax.openplatform")
@ServletComponentScan("com.hfax.openplatform.listeners")
public class ApplicationConfiguration {
	@Autowired
	private RestTemplateBuilder builder;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationConfiguration.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}
}