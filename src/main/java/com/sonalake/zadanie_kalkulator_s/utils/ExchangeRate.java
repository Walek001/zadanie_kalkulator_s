package com.sonalake.zadanie_kalkulator_s.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Transfer object for exchange rate.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ExchangeRate {
    /**
     * Currency code for exchange rate.
     */
    @JsonProperty("code") String currencyCode;
    /**
     * Exchange rate to PLN for currency.
     */
    private Float rate;
    /**
     * Date of update for currency.
     */
    private LocalDate lastUpdate;
    @JsonProperty("rates")
    private void unpackRate(List<Map<String, String>> rates) {
        rate= Float.parseFloat(rates.get(0).get("mid"));
        lastUpdate = LocalDate.parse(rates.get(0).get("effectiveDate"));
    }

}
