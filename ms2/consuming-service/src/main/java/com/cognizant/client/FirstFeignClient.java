package com.cognizant.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "firstfeign",url="http://localhost:9001")
public interface FirstFeignClient {

	@GetMapping("/first")
	public String getFirstMessage();
	
}
