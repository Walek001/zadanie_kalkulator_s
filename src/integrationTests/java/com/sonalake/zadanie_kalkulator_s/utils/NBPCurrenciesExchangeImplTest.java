package com.sonalake.zadanie_kalkulator_s.utils;


import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NBPCurrenciesExchangeImplTest {
    @Autowired
    private NBPCurrenciesExchangeImpl nbpCurrenciesExchange;

    @Test
    void getCurrencyExchangeRate_shouldReturnPLNExchangeRate() throws Exception {
        ExchangeRate exchangeRate = nbpCurrenciesExchange.getCurrencyExchangeRate("PLN");
        assertEquals("PLN", exchangeRate.getCurrencyCode(), "Currency code should be PLN");
        assertEquals(1, exchangeRate.getRate(),"Exchange rate should be 100");
        assertEquals(LocalDate.now(), exchangeRate.getLastUpdate(),"Last date should be today");
    }

    @Test
    void getCurrencyExchangeRate_shouldReturnOtherExchangeRate() throws Exception {
        ExchangeRate exchangeRate = nbpCurrenciesExchange.getCurrencyExchangeRate("USD");
        assertEquals("USD", exchangeRate.getCurrencyCode(), "Currency code should be USD");
        assertNotEquals(1f, exchangeRate.getRate(),"Exchange rate shouldn't be 1");
    }

    @Test
    void getCurrencyExchangeRate_unsupportedCurrencyCode() {
        assertThrows(UnsupportedCurrencyCode.class,() -> nbpCurrenciesExchange.getCurrencyExchangeRate("aaa"));
    }
}