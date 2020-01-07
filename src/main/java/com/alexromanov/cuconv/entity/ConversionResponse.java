package com.alexromanov.cuconv.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversionResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("initialValue")
    private double initialValue;
    @JsonProperty("convertedValue")
    private String convertedValue;
}
