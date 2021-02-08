package net.lnno2.talkingkitchen;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JDBCTest {
	
	@Test
	public void testConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/talkingkitchen?useSSL=false&serverTimezone=Asia/Seoul","ttk_dev","ttk_dev");
			log.info(con.toString());
			
			log.info("git test");
			log.info("git test2");
			
			
			con.close();
			con = null;
			
		} catch (Exception e) {

			e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch(Exception e) {
					
				}
			}
		}
		
	}

}
