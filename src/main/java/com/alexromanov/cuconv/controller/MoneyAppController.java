package com.alexromanov.cuconv.controller;

import com.alexromanov.cuconv.entity.ConvertMoneyForm;
import com.alexromanov.cuconv.entity.ExchangeRateResponse;
import com.alexromanov.cuconv.service.MoneyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MoneyAppController {
	private static final String EXCHANGE_RATE_API = "https://api.exchangeratesapi.io/latest";
	@Autowired
	private RestTemplate restTemplate;

    private final MoneyConverterService moneyConverterService;

    @GetMapping(value = "/")
    public String convertForm(Model model) {
        model.addAttribute("convertMoneyForm", new ConvertMoneyForm());
        return "convert";
    }

    @PostMapping(value = "/")
    public String formatMoney(@Valid ConvertMoneyForm convertMoneyForm,
                              Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "convert";
        }
        String convertResult = moneyConverterService.formatMoney(convertMoneyForm.getValue());
        model.addAttribute("converted", convertResult);
        return "result";
    }

    @GetMapping("/rates/current")
    public String getCurrentRates(Model model){
    	ExchangeRateResponse exchangeRateResponse = restTemplate.getForObject(EXCHANGE_RATE_API, ExchangeRateResponse.class);
    	model.addAttribute("currentRates", exchangeRateResponse);
    	return "exchangerates";
	}
}
