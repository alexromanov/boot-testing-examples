package alexromanov.boottestingexamples.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormatResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("initialValue")
    private double initialValue;
    @JsonProperty("convertedValue")
    private String convertedValue;
}
