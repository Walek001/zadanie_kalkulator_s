package com.sonalake.zadanie_kalkulator_s.services;

import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import com.sonalake.zadanie_kalkulator_s.models.Country;
import com.sonalake.zadanie_kalkulator_s.models.Currency;
import com.sonalake.zadanie_kalkulator_s.models.Offer;
import com.sonalake.zadanie_kalkulator_s.repositories.OfferRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class OfferServiceTest {
    @Mock
    CurrencyService currencyService;

    @Mock
    OfferRepository offerRepository;

    @InjectMocks
    OfferService offerService;

    @Test
    public void calculateOffer_shouldCalcaluateOffer() throws UnsupportedCurrencyCode {
        Offer offer = new Offer();
        Currency currencyMock = mock(Currency.class);
        Country country = new Country();
        country.setFixedCosts(1200);
        country.setCurrency(currencyMock);
        country.setTax(19);
        offer.setCountry(country);
        offer.setDailyPayment(100f);
        Mockito.when(currencyService.getCurrentCurrencyRateFor(country)).thenReturn(currencyMock);
        Mockito.when(currencyMock.getExchangeRate()).thenReturn(1f);

        CalculatedOffer result = offerService.calculateOffer(offer);

        assertEquals(810.0f, result.getNettoMonthPayment(), "Monthly payment should be 810");
        assertEquals(country, result.getCountry(), "Monthly payment should be 810");
    }

}