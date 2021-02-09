package net.lnno2.talkingkitchen;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {net.lnno2.talkingkitchen.config.RootConfig.class} )
@Slf4j
public class HikariCPTests {

	@Setter(onMethod = @__({@Autowired}))
	private DataSource ds;
	

	@Test
	public void testDataSource() {
		
		try(Connection con = ds.getConnection()) {
			
		} catch (Exception e) {
			log.info("에러...");
			e.printStackTrace();
		}
		
	}
	
	
}
