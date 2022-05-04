package com.cognizant;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class MyPostFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("============ POST FILTER STARTED ==============");
		ServerHttpResponse response=exchange.getResponse();
		System.out.println("HTTP status code ::===>"+response.getStatusCode());
		System.out.println("Headers ::===>"+response.getHeaders());
		return chain.filter(exchange)
				.then(Mono.fromRunnable(
				()->{System.out.println("=====POST Filter Completed====");}));
	}

}
