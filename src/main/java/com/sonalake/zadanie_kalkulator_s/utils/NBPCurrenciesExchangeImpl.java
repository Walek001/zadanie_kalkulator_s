package com.sonalake.zadanie_kalkulator_s.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class NBPCurrenciesExchangeImpl implements CurrenciesExchange {
    private RestTemplate restTemplate = new RestTemplate();

    private final String uri = "http://api.nbp.pl/api/exchangerates/rates/a/USD?format=json";


    @Override
    public ExchangeRate getCurrencyExchangeRate(String currencyCode) {
        if(currencyCode.equals("PLN"))
            return new ExchangeRate(currencyCode, 1f, LocalDate.now());
        else {
            return restTemplate.getForObject(uri, ExchangeRate.class);
        }
    }
}
