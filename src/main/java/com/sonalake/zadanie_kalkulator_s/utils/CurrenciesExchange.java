package com.sonalake.zadanie_kalkulator_s.utils;

import com.sonalake.zadanie_kalkulator_s.exceptions.ServerNotRespondingException;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;

public interface CurrenciesExchange {
    ExchangeRate getCurrencyExchangeRate(String currencyCode) throws UnsupportedCurrencyCode, ServerNotRespondingException;
}
