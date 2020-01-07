package com.alexromanov.cuconv.controller;

import com.alexromanov.cuconv.entity.ConversionRequest;
import com.alexromanov.cuconv.entity.ConversionResponse;
import com.alexromanov.cuconv.service.MoneyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MoneyConverterController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private final MoneyConverterService moneyConverterService;

    @PostMapping(value = "/convert", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ConversionResponse formatMoney(@Valid @RequestBody ConversionRequest request) {
        String result = moneyConverterService.formatMoney(request.getInputValue());
        final ConversionResponse conversionResponse;

        if (result.isEmpty()) {
            conversionResponse = ConversionResponse.builder()
                                                   .status(ERROR_STATUS)
                                                   .initialValue(request.getInputValue())
                                                   .convertedValue("")
                                                   .build();
        } else {
            conversionResponse = ConversionResponse.builder()
                                                   .status(SUCCESS_STATUS)
                                                   .initialValue(request.getInputValue())
                                                   .convertedValue(result)
                                                   .build();
        }
        return conversionResponse;
    }
}
