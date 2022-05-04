package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

/*	@Value("${first-service.message}")
	String first; */
	
	@Autowired
	MyMessageReadConfig config;
	
	@GetMapping("/first")
	public String getFirstMessage() {
		return config.getMessage();
	}
}
