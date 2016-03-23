package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Locale;
import java.util.Properties;

@ComponentScan(basePackages = { "com.example.controller" })
@Configuration
@EnableWebMvc
public class SpringMVCContext extends WebMvcConfigurerAdapter {
	private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views/";
	private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/vendor/**").addResourceLocations("/vendor/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
		viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
		return viewResolver;
	}

    @Bean
	public SimpleMappingExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties exceptionMappings = new Properties();
		exceptionMappings.put("java.lang.Exception", "error/error");
		exceptionMappings.put("java.lang.RuntimeException", "error/error");
		exceptionResolver.setExceptionMappings(exceptionMappings);
		Properties statusCodes = new Properties();
		statusCodes.put("error/404", "404");
		statusCodes.put("error/error", "500");
		exceptionResolver.setStatusCodes(statusCodes);
		return exceptionResolver;
	}

}
