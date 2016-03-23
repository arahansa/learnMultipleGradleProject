package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.sql.DataSource;

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
