package com.sonalake.zadanie_kalkulator_s.utils;

import com.sonalake.zadanie_kalkulator_s.exceptions.ServerNotRespondingException;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

/**
 * NBP Currencies Exchange implementation for providing currency exchange rate based on nbp api.
 */
@Component
public class NBPCurrenciesExchangeImpl implements CurrenciesExchange {
    private RestTemplate restTemplate;
    private String base_uri;

    public NBPCurrenciesExchangeImpl(@Value("${nbp.base-url}") String base_uri) {
        this.restTemplate = new RestTemplate();
        this.base_uri = base_uri;
    }

    /**
     * This method returns Exchange Rate for provided currency code.
     * @param currencyCode for currency which exchange rate should be provided
     * @return {@link ExchangeRate} for provided currency code.
     * @throws UnsupportedCurrencyCode when procided currency code is not supported by api.
     * @throws ServerNotRespondingException when nbp api is down
     */
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
                    throw new UnsupportedCurrencyCode(currencyCode);
                else
                    throw new ServerNotRespondingException();
            }
        }
    }
}
