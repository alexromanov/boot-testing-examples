package com.alexromanov.cuconv.entity;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertMoneyForm {
    @Pattern(regexp = "^-?[0-9]{1,13}(.?,?[0-9]+)?$", message = "Value should not be empty and should be in decimal format")
    private String value;
}
