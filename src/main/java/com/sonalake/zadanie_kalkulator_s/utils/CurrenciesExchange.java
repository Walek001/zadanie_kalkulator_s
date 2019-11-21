package com.sonalake.zadanie_kalkulator_s.utils;

import com.sonalake.zadanie_kalkulator_s.exceptions.ServerNotRespondingException;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;

/**
 * Interface for currencies exchange, if needed additional currency exchange api, you should implement this api.
 */
public interface CurrenciesExchange {
    /**
     * This method returns Exchange Rate for provided currency code.
     * @param currencyCode for currency which exchange rate should be provided
     * @return {@link ExchangeRate} for provided currency code.
     * @throws UnsupportedCurrencyCode when procided currency code is not supported by api.
     * @throws ServerNotRespondingException when nbp api is down
     */
    ExchangeRate getCurrencyExchangeRate(String currencyCode) throws UnsupportedCurrencyCode, ServerNotRespondingException;
}
