package com.example.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({ SpringMVCContext.class})
@ComponentScan(basePackages = { "com.example" })
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class ApplicationContext {

	@Bean
	public PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
