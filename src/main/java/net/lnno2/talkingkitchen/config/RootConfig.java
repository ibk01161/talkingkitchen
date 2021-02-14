package net.lnno2.talkingkitchen.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@MapperScan(basePackages = {"net.lnno2.talkingkitchen.mapper"})
public class RootConfig {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	// Hikari 설정
	@Bean
	public DataSource dataSource() {
		
		log.info("datasource...");
		HikariConfig hikariConfig = new HikariConfig();
//		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		// log4jdbc 사용
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//		hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/talkingkitchen?useSSL=false&serverTimezone=Asia/Seoul");
		// log4jdbc 사용
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://127.0.0.1:3306/talkingkitchen?useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Seoul");
		hikariConfig.setUsername("ttk_dev");
		hikariConfig.setPassword("ttk_dev");
		// 아무런 일을 하지 않아도 설정 값 size로 커넥션들을 유지해주는 설정
		hikariConfig.setMinimumIdle(1);
		
		// 데이터베이스 연결이 여전히 활성화 되어있는지 확인하기 위해 pool에서 connection을 제공하기 전 실행되는 쿼리
		hikariConfig.setConnectionTestQuery("SELECT sysdate() FROM dual");
		// 사용자가 pool의 이름을 지정 (로깅 및 JMX 관리 콘솔에 표시되어 풀 구성을 식별)
		hikariConfig.setPoolName("springHikariCP");
		
		hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "200");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
		hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
		
	}
	
	
	// SQLSessionFactory 설정
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
		log.info("sqlsession...");
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		// mybatis-config 설정 적용
		sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		// resources에 있는 mapper xml 경로 설정 (classpath는 scr/main/resources를 뜻함)
		sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
		return (SqlSessionFactory) sqlSessionFactory.getObject();
		
	}
	
	// Transaction 설정
	@Bean
	public DataSourceTransactionManager txManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}

}
