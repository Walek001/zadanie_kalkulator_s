package com.sonalake.zadanie_kalkulator_s.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class ExchangeRate {
    @JsonProperty("code") String currencyCode;
    Float rate;
    LocalDate lastUpdate;
    @JsonProperty("rates")
    private void unpackRate(List<Map<String, String>> rates) {
        rate= Float.parseFloat(rates.get(0).get("mid"));
        lastUpdate = LocalDate.parse(rates.get(0).get("effectiveDate"));
    }

}
