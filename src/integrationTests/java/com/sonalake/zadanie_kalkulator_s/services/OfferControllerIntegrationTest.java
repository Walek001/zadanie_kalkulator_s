package com.sonalake.zadanie_kalkulator_s.services;

import com.sonalake.zadanie_kalkulator_s.DTOs.DisplayOfferDTO;
import com.sonalake.zadanie_kalkulator_s.controllers.OfferController;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import com.sonalake.zadanie_kalkulator_s.models.Country;
import com.sonalake.zadanie_kalkulator_s.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OfferControllerIntegrationTest {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private OfferController offerController;

    @Test
    public void calcOfferTest() throws UnsupportedCurrencyCode {
        Optional<Country> country = countryRepository.findById(1);

        DisplayOfferDTO result = offerController.createOffer(country.get(), 10000);

        assertEquals(810f, result.getMonthPayment());
        assertEquals("PL", result.getCountryCode());
    }
}
