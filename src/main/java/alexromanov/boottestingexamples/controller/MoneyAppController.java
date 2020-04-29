package alexromanov.boottestingexamples.controller;

import alexromanov.boottestingexamples.entity.ConvertMoneyForm;
import alexromanov.boottestingexamples.entity.ExchangeRateResponse;
import alexromanov.boottestingexamples.service.ExchangeRateService;
import alexromanov.boottestingexamples.service.MoneyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MoneyAppController {
	@Autowired
    private MoneyConverterService moneyConverterService;
	@Autowired
	private ExchangeRateService exchangeRateService;

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
    	ExchangeRateResponse exchangeRateResponse = exchangeRateService.getCurrentExchangeRates();
    	model.addAttribute("currentRates", exchangeRateResponse);
    	return "exchangerates";
	}
}
