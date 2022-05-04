package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

	@Autowired
	MyMessageReadConfig config;

	@GetMapping("/second")
	public String getSecondMessage() {
		return config.getMessage();
	}
}
