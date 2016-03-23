package com.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;
import java.util.Properties;

@ComponentScan(basePackages = { "com.example.controller" })
@Configuration
@EnableWebMvc
public class SpringMVCContext extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(messageConverter());
	}

	// JSON Converter Config
	@Bean
	public ObjectMapper objectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}
	@Bean
	public MappingJackson2HttpMessageConverter messageConverter(){
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.setObjectMapper(objectMapper());
		return messageConverter;
	}

}
