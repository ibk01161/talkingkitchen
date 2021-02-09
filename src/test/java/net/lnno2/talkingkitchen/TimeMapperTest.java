package net.lnno2.talkingkitchen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import net.lnno2.talkingkitchen.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {net.lnno2.talkingkitchen.config.RootConfig.class} )
@Slf4j
public class TimeMapperTest {
	
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		
		try {

			log.info(timeMapper.getTime2());
			
		} catch (Exception e) {
			log.info("에러");
			log.info(e.getMessage());
		}
		
		
		
	}

}
