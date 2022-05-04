package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cognizant.client.FirstFeignClient;
import com.cognizant.client.SecondFeignClient;

@EnableFeignClients(basePackages = "com.cognizant.client")
@RestController
public class ConsumingController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	FirstFeignClient firstFeign;
	@Autowired
	SecondFeignClient secondFeign;
	
	@Autowired
	WebClient.Builder builder;

	@GetMapping("/message")
	public String getMessage() {
	//	String first=restTemplate.getForObject("http://localhost:9001/first", String.class);
	//	String second=restTemplate.getForObject("http://localhost:9002/second", String.class);
	//	String second=restTemplate.getForObject("http://second-service:9002/second", String.class);
	//	String first=restTemplate.getForObject("http://first-service:9001/first", String.class);		
		
		// using Open Feign client call
	//	String first=firstFeign.getFirstMessage();
	//	String second=secondFeign.getSecondMessage();
		
		//Using reactive webclient
		
		String first=builder.build()
				.get()
				.uri("http://localhost:9001/first")
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		String second=builder.build()
				.get()
				.uri("http://localhost:9002/second")
				.retrieve()
				.bodyToMono(String.class)
				.block();
		return first+second;
	}
}
