package com.sonalake.zadanie_kalkulator_s.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NBPCurrenciesExchangeImplTest {
    private NBPCurrenciesExchangeImpl nbpCurrenciesExchange = new NBPCurrenciesExchangeImpl();

    @Test
    void getCurrencyExchangeRate_shouldReturnPLNExchangeRate() {
        ExchangeRate exchangeRate = nbpCurrenciesExchange.getCurrencyExchangeRate("PLN");
        assertEquals("PLN", exchangeRate.currencyCode, "Currency code should be PLN");
        assertEquals(100, exchangeRate.rate,"Exchange rate should be 100");
        assertEquals(LocalDate.now(), exchangeRate.lastUpdate,"Last date should be today");
    }

    @Test
    void getCurrencyExchangeRate_shouldReturnUSDExchangeRate() {
        ExchangeRate exchangeRate = nbpCurrenciesExchange.getCurrencyExchangeRate("USD");
        assertEquals("USD", exchangeRate.currencyCode, "Currency code should be USD");
        assertEquals(310, exchangeRate.rate,"Exchange rate should be 310");
        assertEquals(LocalDate.now(), exchangeRate.lastUpdate,"Last date should be today");
    }
}