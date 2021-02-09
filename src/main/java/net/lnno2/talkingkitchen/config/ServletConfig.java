package net.lnno2.talkingkitchen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class ServletConfig extends WebMvcConfigurationSupport {

	// 화면 처리 방식 설정 (jsp) -> '/WEB-INF/views'라는 폴더 내 이름들을 사용하고, '.jsp' 파일 사용
	// 오류시 @Bean 추가하기
	public ViewResolver mvcViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views");
		bean.setSuffix(".jsp");
		return bean;
	}
	
	// 정적인 자원들의 기본 경로 지정
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resoureces/");
	}

}
