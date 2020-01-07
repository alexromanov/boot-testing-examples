package com.alexromanov.cuconv.controller;

import com.alexromanov.cuconv.entity.ExchangeRateResponse;
import com.alexromanov.cuconv.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rates")
public class ExchangeRateController {
	@Autowired
	private ExchangeRateService exchangeRateService;

	@GetMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
	public ExchangeRateResponse displayCurrentExchangeRates(){
		return exchangeRateService.getCurrentExchangeRates();
	}
}
