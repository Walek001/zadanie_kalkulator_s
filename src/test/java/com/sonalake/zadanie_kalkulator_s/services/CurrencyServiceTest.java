package com.sonalake.zadanie_kalkulator_s.services;

import com.sonalake.zadanie_kalkulator_s.exceptions.ServerNotRespondingException;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import com.sonalake.zadanie_kalkulator_s.models.Country;
import com.sonalake.zadanie_kalkulator_s.models.Currency;
import com.sonalake.zadanie_kalkulator_s.repositories.CurrencyRepository;
import com.sonalake.zadanie_kalkulator_s.utils.CurrenciesExchange;
import com.sonalake.zadanie_kalkulator_s.utils.ExchangeRate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {
    @Mock
    CurrencyRepository currencyRepository;

    @Mock
    CurrenciesExchange nbpCurrenciesExchangeMock;

    @InjectMocks
    CurrencyService currencyService;

    @Test
    void getCurrentCurrencyRate_shouldReturnPLNCurrency() throws UnsupportedCurrencyCode {
        //Given
        Currency currency = new Currency();
        currency.setCurrencyCode("PLN");
        currency.setLastUpdate(LocalDate.MAX);
        Country country = new Country(1, "PL", 10, 1200, currency,Collections.emptyList());

        Currency result = currencyService.getCurrentCurrencyRateFor(country);
        assertEquals("PLN", result.getCurrencyCode(), "Expected currency code be \"PLN\"");
    }

    @Test
    void getCurrentCurrencyRate_shouldReturnUpdateCurrency() throws UnsupportedCurrencyCode, ServerNotRespondingException {
        //Given
        Currency currency = new Currency();
        currency.setCurrencyCode("CHF");
        currency.setLastUpdate(LocalDate.MIN);
        currency.setExchangeRate(1f);
        Country country = new Country(1, "CH", 10, 1200, currency,Collections.emptyList());
        ExchangeRate er = new ExchangeRate("CHF", 3f, LocalDate.now());
        Mockito.when(nbpCurrenciesExchangeMock.getCurrencyExchangeRate(currency.getCurrencyCode())).thenReturn(er);
        Mockito.when(currencyRepository.save(any(Currency.class))).thenAnswer(i -> i.getArguments()[0]);

//        When
        Currency result = currencyService.getCurrentCurrencyRateFor(country);

//        Then
        assertEquals("CHF", result.getCurrencyCode(), "Expected currency code be \"CHF\"");
        assertEquals(3f, result.getExchangeRate(), "Expected currency exchangerate changed to 3f");
        assertEquals(LocalDate.now(), result.getLastUpdate(), "Expected currency update was today.");
        verify(nbpCurrenciesExchangeMock, times(1)).getCurrencyExchangeRate(currency.getCurrencyCode());
        verify(currencyRepository, times(1)).save(any());
    }

    @Test
    void getCurrentCurrencyRate_shouldReturnNotUpdatedCurrency() throws UnsupportedCurrencyCode, ServerNotRespondingException {
        //Given
        Currency currency = new Currency();
        currency.setCurrencyCode("CHF");
        currency.setLastUpdate(LocalDate.MIN);
        currency.setExchangeRate(1f);
        Country country = new Country(1, "CH", 10, 1200, currency,Collections.emptyList());
        Mockito.when(nbpCurrenciesExchangeMock.getCurrencyExchangeRate(currency.getCurrencyCode())).thenThrow(ServerNotRespondingException.class);

//        When
        Currency result = currencyService.getCurrentCurrencyRateFor(country);

//        Then
        assertEquals("CHF", result.getCurrencyCode(), "Expected currency code be \"CHF\"");
        assertEquals(1f, result.getExchangeRate(), "Expected currency exchangerate should stay same");
        assertEquals(LocalDate.MIN, result.getLastUpdate(), "Expected currency update was LocalDate.MIN.");
        verify(nbpCurrenciesExchangeMock, times(1)).getCurrencyExchangeRate(currency.getCurrencyCode());
        verify(currencyRepository, times(0)).save(any());
    }
}