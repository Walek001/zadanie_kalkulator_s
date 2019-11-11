package com.sonalake.zadanie_kalkulator_s.utils;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NBPCurrenciesExchangeImplTest {
    private NBPCurrenciesExchangeImpl nbpCurrenciesExchange = new NBPCurrenciesExchangeImpl();

    @Test
    void getCurrencyExchangeRate_shouldReturnPLNExchangeRate() {
        ExchangeRate exchangeRate = nbpCurrenciesExchange.getCurrencyExchangeRate("PLN");
        assertEquals("PLN", exchangeRate.currencyCode, "Currency code should be PLN");
        assertEquals(1, exchangeRate.rate,"Exchange rate should be 100");
        assertEquals(LocalDate.now(), exchangeRate.lastUpdate,"Last date should be today");
    }

    @Test
    void getCurrencyExchangeRate_shouldReturnOtherExchangeRate() {
        ExchangeRate exchangeRate = nbpCurrenciesExchange.getCurrencyExchangeRate("USD");
        assertEquals("USD", exchangeRate.currencyCode, "Currency code should be USD");
        assertNotEquals(1f, exchangeRate.rate,"Exchange rate shouldn't be 1");
    }
}