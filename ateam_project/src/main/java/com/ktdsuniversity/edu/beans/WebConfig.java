package com.ktdsuniversity.edu.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ktdsuniversity.edu.beans.filter.xss.XssEscapeServletFilter;

@Configuration
@Configurable 
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**")
		        .addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/css/**")
        .addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/images/**")
        .addResourceLocations("classpath:/static/images/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//세션 체크를 하지 않을URL을 적어주세요.
		
		List<String> excludePatterns = new ArrayList<>();
		excludePatterns.add("/member/signup/**");
		excludePatterns.add("/member/auth");
		excludePatterns.add("/freeboard/list");
		excludePatterns.add("/home/main");
		excludePatterns.add("/js/**");
		excludePatterns.add("/css/**");
		excludePatterns.add("/img/**");
		excludePatterns.add("/news/**");
		excludePatterns.add("/error");
		excludePatterns.add("/algorithm/**");
		excludePatterns.add("/member/regist");
		excludePatterns.add("/qnaboard/list");

		
		registry.addInterceptor(new CheckSessionInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns(excludePatterns);
	}
	
	@Bean
	public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
		FilterRegistrationBean<XssEscapeServletFilter> filterRegistration = new FilterRegistrationBean<>();
		filterRegistration.setFilter(new XssEscapeServletFilter());
		filterRegistration.setOrder(1);
		filterRegistration.addUrlPatterns("/*");
		return filterRegistration;
	}

	
}
