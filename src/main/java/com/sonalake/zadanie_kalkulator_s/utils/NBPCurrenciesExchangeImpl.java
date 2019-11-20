package com.sonalake.zadanie_kalkulator_s.utils;

import com.sonalake.zadanie_kalkulator_s.exceptions.ServerNotRespondingException;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class NBPCurrenciesExchangeImpl implements CurrenciesExchange {
    private RestTemplate restTemplate;
    private String base_uri;

    public NBPCurrenciesExchangeImpl(@Value("${nbp.base-url}") String base_uri) {
        this.restTemplate = new RestTemplate();
        this.base_uri = base_uri;
    }

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
