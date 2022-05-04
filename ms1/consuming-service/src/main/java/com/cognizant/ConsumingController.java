package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumingController {

	@Autowired
	RestTemplate restTemplate;
	

	@GetMapping("/message")
	public String getMessage() {
		String first=restTemplate.getForObject("http://localhost:9001/first", String.class);
		String second=restTemplate.getForObject("http://localhost:9002/second", String.class);
		return first+second;
	}
}
