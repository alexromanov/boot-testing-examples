package alexromanov.boottestingexamples.controller;

import alexromanov.boottestingexamples.entity.FormatRequest;
import alexromanov.boottestingexamples.entity.FormatResponse;
import alexromanov.boottestingexamples.service.FormatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MoneyFormatController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private final FormatterService formatterService;

    @PostMapping(value = "/format", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public FormatResponse formatMoney(@Valid @RequestBody FormatRequest request) {
        String result = formatterService.formatMoney(request.getInputValue());
        final FormatResponse formatResponse;

        if (result.isEmpty()) {
            formatResponse = FormatResponse.builder()
                                           .status(ERROR_STATUS)
                                           .initialValue(request.getInputValue())
                                           .convertedValue("")
                                           .build();
        } else {
            formatResponse = FormatResponse.builder()
                                           .status(SUCCESS_STATUS)
                                           .initialValue(request.getInputValue())
                                           .convertedValue(result)
                                           .build();
        }
        return formatResponse;
    }
}
