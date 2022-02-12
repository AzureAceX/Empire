// package com.urillah.empireproj;

// import org.modelmapper.ModelMapper;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

// @Configuration
// public class EmpireConfig {

// 	//Basic MVC controller to emulate pages prior to front end routing - 
// 	public void addViewControllers(ViewControllerRegistry registry) {
// 		registry.addViewController("/home").setViewName("home");
// 		registry.addViewController("/").setViewName("home");
// 		registry.addViewController("/hello").setViewName("hello");
// 		registry.addViewController("/login").setViewName("login");
// 	}
	
// 	//Used for the entity to DTO mappings
// 	@Bean
// 	public ModelMapper modelMapper() {
// 	    return new ModelMapper();
// 	}
// }
