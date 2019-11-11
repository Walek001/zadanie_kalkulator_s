package com.sonalake.zadanie_kalkulator_s.utils;

import okhttp3.Call;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NBPCurrenciesExchangeImpl implements CurrenciesExchange {
    @Override
    public ExchangeRate getCurrencyExchangeRate(String currencyCode) {
        if(currencyCode.equals("PLN"))
            return new ExchangeRate(currencyCode, 100, LocalDate.now());
        else {
            return new ExchangeRate(currencyCode, 310, LocalDate.now());
        }
    }
}
