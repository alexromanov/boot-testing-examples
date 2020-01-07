package com.alexromanov.cuconv.entity;

import lombok.Data;

@Data
public class ExchangeRate {
	private String currency;
	private Long value;
}
