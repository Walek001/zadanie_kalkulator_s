package com.sonalake.zadanie_kalkulator_s.services;

import com.sonalake.zadanie_kalkulator_s.DTOs.DisplayOfferDTO;
import com.sonalake.zadanie_kalkulator_s.controllers.OfferController;
import com.sonalake.zadanie_kalkulator_s.exceptions.CountryNotExist;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OfferControllerIntegrationTest {
    @Autowired
    private CountryService countryService;

    @Autowired
    private OfferController offerController;

    @Test
    public void calcOfferTest() throws UnsupportedCurrencyCode, CountryNotExist {
        DisplayOfferDTO result = offerController.createOffer(1, 10000);

        assertEquals(810f, result.getMonthPayment());
        assertEquals("PL", result.getCountryCode());
    }

    @Test
    public void calcOfferTest_shouldThrowException() {
        assertThrows(CountryNotExist.class,() -> offerController.createOffer(100, 10000));
    }
}
