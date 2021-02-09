package net.lnno2.talkingkitchen.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = {"net.lnno2.talkingkitchen.mapper"})
public class RootConfig {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	// Hikari ����
	@Bean
	public DataSource dataSource() {
		
		HikariConfig hikariConfig = new HikariConfig();
//		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		// log4jdbc ���
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//		hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/talkingkitchen?useSSL=false&serverTimezone=Asia/Seoul");
		// log4jdbc ���
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://127.0.0.1:3306/talkingkitchen?useSSL=false&serverTimezone=Asia/Seoul");
		hikariConfig.setUsername("ttk_dev");
		hikariConfig.setPassword("ttk_dev");
		// �ƹ��� ���� ���� �ʾƵ� ���� �� size�� Ŀ�ؼǵ��� �������ִ� ����
		hikariConfig.setMinimumIdle(1);
		
		// �����ͺ��̽� ������ ������ Ȱ��ȭ �Ǿ��ִ��� Ȯ���ϱ� ���� pool���� connection�� �����ϱ� �� ����Ǵ� ����
		hikariConfig.setConnectionTestQuery("SELECT sysdate() FROM dual");
		// ����ڰ� pool�� �̸��� ���� (�α� �� JMX ���� �ֿܼ� ǥ�õǾ� Ǯ ������ �ĺ�)
		hikariConfig.setPoolName("springHikariCP");
		
		hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "200");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
		hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
		
	}
	
	
	// SQLSessionFactory ����
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		// resources�� �ִ� mapper xml ��� ���� (classpath�� scr/main/resources�� ����
		sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
		return (SqlSessionFactory) sqlSessionFactory.getObject();
		
	}
	

}
