package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@Autowired
	Environment env;
	
	@GetMapping("/first")
	public String getFirstMessage() {
		return "Hello : "+env.getProperty("server.port");
	}
}
