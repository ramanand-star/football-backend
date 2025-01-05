package com.example.beverage;

import com.example.beverage.filter.RateLimiterFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeverageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeverageApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<RateLimiterFilter> rateLimiterFilter() {
		System.out.println("RateLimiterFilter");
		//Token Bucket algorithm
		FilterRegistrationBean<RateLimiterFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new RateLimiterFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}

}
