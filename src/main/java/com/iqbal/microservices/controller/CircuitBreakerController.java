package com.iqbal.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping(path = "/currency-exchange")
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping(path = "/sample-api")
	// @Retry(name = "sampe-api", fallbackMethod = "handleFallback")
	@CircuitBreaker(name = "defalut", fallbackMethod = "handleFallback")
	public String sampleApi() {
		logger.info("sample api");

		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:2222", String.class);

		return forEntity.getBody();
	}

	public String handleFallback(Exception ex) {
		return "fallback respone";
	}

}
