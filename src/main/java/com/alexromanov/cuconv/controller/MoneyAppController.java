package com.alexromanov.cuconv.controller;

import com.alexromanov.cuconv.entity.ConvertMoneyForm;
import com.alexromanov.cuconv.service.MoneyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MoneyAppController {
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
}
