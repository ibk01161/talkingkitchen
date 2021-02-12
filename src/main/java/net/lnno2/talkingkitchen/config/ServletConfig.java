package net.lnno2.talkingkitchen.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"net.lnno2.talkingkitchen.controller", "net.lnno2.talkingkitchen.service"})
public class ServletConfig implements WebMvcConfigurer {
	
	// 화면 처리 방식 설정 (jsp) -> '/WEB-INF/views/'라는 폴더 내 이름들을 사용하고, '.jsp' 파일 사용
	public void configureViewResolvers(ViewResolverRegistry registry) {
		log.info("view...");
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 정적인 자원들의 기본 경로 지정
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("handlers...");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
