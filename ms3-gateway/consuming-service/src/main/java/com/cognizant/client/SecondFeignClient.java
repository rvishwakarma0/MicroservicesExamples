package com.cognizant.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "secondfeign",url="http://localhost:9002")
public interface SecondFeignClient {

	@GetMapping("/second")
	public String getSecondMessage();
	
}
