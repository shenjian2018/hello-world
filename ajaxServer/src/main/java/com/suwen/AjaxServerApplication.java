package com.suwen;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AjaxServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjaxServerApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean  registFilter() {
		FilterRegistrationBean  bean=new  FilterRegistrationBean();
		bean.addUrlPatterns("/*");
		bean.setFilter(new CroseFifter());
		return bean;
	}
}
