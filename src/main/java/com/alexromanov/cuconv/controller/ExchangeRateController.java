package com.alexromanov.cuconv.controller;

import com.alexromanov.cuconv.entity.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rates")
public class ExchangeRateController {
	private static final String EXCHANGE_RATE_API = "https://api.exchangeratesapi.io/latest";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
	public ExchangeRateResponse displayCurrentExchangeRates(){
		return restTemplate.getForObject(EXCHANGE_RATE_API, ExchangeRateResponse.class);
	}
}
