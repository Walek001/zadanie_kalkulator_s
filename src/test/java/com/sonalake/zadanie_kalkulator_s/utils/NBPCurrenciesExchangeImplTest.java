package com.sonalake.zadanie_kalkulator_s.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class NBPCurrenciesExchangeImplTest {
    private NBPCurrenciesExchangeImpl nbpCurrenciesExchange = new NBPCurrenciesExchangeImpl();

    @Test
    void getCurrencyExchangeRate_shouldReturnPLNExchangeRate() throws Exception {
        ExchangeRate exchangeRate = nbpCurrenciesExchange.getCurrencyExchangeRate("PLN");
        assertEquals("PLN", exchangeRate.currencyCode, "Currency code should be PLN");
        assertEquals(1, exchangeRate.rate,"Exchange rate should be 100");
        assertEquals(LocalDate.now(), exchangeRate.lastUpdate,"Last date should be today");
    }

    @Test
    void getCurrencyExchangeRate_shouldReturnOtherExchangeRate() throws Exception {
        ExchangeRate exchangeRate = nbpCurrenciesExchange.getCurrencyExchangeRate("USD");
        assertEquals("USD", exchangeRate.currencyCode, "Currency code should be USD");
        assertNotEquals(1f, exchangeRate.rate,"Exchange rate shouldn't be 1");
    }

    @Test
    void getCurrencyExchangeRate_unsupportedCurrencyCode() {
        assertThrows(UnsupportedCurrencyCode.class,() -> nbpCurrenciesExchange.getCurrencyExchangeRate("aaa"));
    }
}