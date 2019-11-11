package com.sonalake.zadanie_kalkulator_s.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class NBPCurrenciesExchangeImpl implements CurrenciesExchange {
    private RestTemplate restTemplate = new RestTemplate();

    private final String base_uri = "http://api.nbp.pl/api/exchangerates/rates/a/";


    @Override
    public ExchangeRate getCurrencyExchangeRate(String currencyCode) throws UnsupportedCurrencyCode, ServerNotRespondingException {
        if(currencyCode.equals("PLN"))
            return new ExchangeRate(currencyCode, 1f, LocalDate.now());
        else {
            String uri = base_uri + currencyCode + "?format=json";
            try {
                return restTemplate.getForObject(uri, ExchangeRate.class);
            } catch (HttpClientErrorException e) {
                if(e.getRawStatusCode() == 404)
                    throw new UnsupportedCurrencyCode();
                else
                    throw new ServerNotRespondingException();
            }
        }
    }
}
