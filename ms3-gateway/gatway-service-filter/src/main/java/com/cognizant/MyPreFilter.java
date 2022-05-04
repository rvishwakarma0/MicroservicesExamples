package com.cognizant;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyPreFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
	System.out.println("************************ PRE-FILTER-STARTED *******************");
	ServerHttpRequest request=exchange.getRequest();
	System.out.println("Headers :===>"+request.getHeaders().toString());
	System.out.println("LocalAddress :===>"+request.getLocalAddress());
	System.out.println("RemoteAddress :===>"+request.getRemoteAddress());
	System.out.println("Path :===>"+request.getPath());
	System.out.println("URI :===>"+request.getURI());
	System.out.println("Method :===>"+request.getMethod());
	return chain.filter(exchange);
	}

}
