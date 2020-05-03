package alexromanov.boottestingexamples.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Service
@Slf4j
public class FormatterService {
    public String formatMoney(String inputMoney) {
        log.info("Received value for formatting: {}", inputMoney);
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
            log.error(ex.getMessage());
        }
        log.info("Formatted result: {}", formatted);
        return formatted;
    }

    public String formatMoney(double input) {
        return formatMoney(String.valueOf(input));
    }
}
