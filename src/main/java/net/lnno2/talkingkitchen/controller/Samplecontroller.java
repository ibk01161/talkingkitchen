package net.lnno2.talkingkitchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class Samplecontroller {
	
	@GetMapping("/hello")
	public void hello() {
		
		log.info("hello.....");
		
		
	}
	

}
