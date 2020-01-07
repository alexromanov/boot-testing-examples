package com.alexromanov.cuconv.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Service
public class MoneyConverterService {
    public String formatMoney(String inputMoney) {
        if (inputMoney == null || inputMoney.isEmpty()) {
            return inputMoney;
        }
        inputMoney = inputMoney.replace(',', '.');
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        symbols.setDecimalSeparator('.');

        DecimalFormat formatter = new DecimalFormat("###,##0.00", symbols);
        String formatted = "";
        try {
            formatted = formatter.format(Double.parseDouble(inputMoney));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return formatted;
    }

    public String formatMoney(double input) {
        return formatMoney(String.valueOf(input));
    }
}
