package com.dsny.hack.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**", "/css/**", "/img/**")
		.addResourceLocations("classpath:/bower_components/Materialize/dist/")
		.addResourceLocations("classpath:/bower_components/angular/")
		.addResourceLocations("classpath:/bower_components/jquery/dist/")
		.addResourceLocations("classpath:/css/")
		.addResourceLocations("classpath:/lib/")
		.addResourceLocations("classpath:/js/"); 
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/partials/events").setViewName("partials/events");
		registry.addViewController("/partials/event-add").setViewName("partials/event-add");
		registry.addViewController("/partials/event-edit").setViewName("partials/event-edit");
		registry.addViewController("/partials/event-view").setViewName("partials/event-view");
		registry.addViewController("/partials/_form").setViewName("partials/_form");
	}

}