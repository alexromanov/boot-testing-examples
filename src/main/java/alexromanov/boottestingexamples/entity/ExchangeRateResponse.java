package alexromanov.boottestingexamples.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class ExchangeRateResponse {
	@JsonProperty("base")
	private String base;
	@JsonProperty("date")
	private String date;
	@JsonProperty("rates")
	private Map<String, Long> rates;
}
