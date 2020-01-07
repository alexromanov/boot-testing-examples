package com.alexromanov.cuconv.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExchangeRateResponse {
	@JsonProperty("base")
	private String base;
	@JsonProperty("date")
	private String date;
	@JsonProperty("rates")
	private List<ExchangeRate> rates;
}
