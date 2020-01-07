package com.alexromanov.cuconv.service;

import com.alexromanov.cuconv.entity.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateService {
	private static final String EXCHANGE_RATE_API = "https://api.exchangeratesapi.io/latest";

	@Autowired
	private RestTemplate restTemplate;

	public ExchangeRateResponse getCurrentExchangeRates(){
		return restTemplate.getForObject(EXCHANGE_RATE_API, ExchangeRateResponse.class);
	}
}
