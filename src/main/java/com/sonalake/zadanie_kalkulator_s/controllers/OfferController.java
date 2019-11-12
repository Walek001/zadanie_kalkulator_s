package com.sonalake.zadanie_kalkulator_s.controllers;

import com.sonalake.zadanie_kalkulator_s.DTOs.DisplayOfferDTO;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import com.sonalake.zadanie_kalkulator_s.models.Country;
import com.sonalake.zadanie_kalkulator_s.models.Offer;
import com.sonalake.zadanie_kalkulator_s.services.CalculatedOffer;
import com.sonalake.zadanie_kalkulator_s.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class OfferController {
    static final String OFFERS_PATH = "/offers";

    private OfferService offerService;

    public OfferController(@Autowired OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping(OFFERS_PATH)
    public DisplayOfferDTO createOffer(Country country, @RequestParam Integer dailyPayment) throws UnsupportedCurrencyCode {
        Offer offer = offerService.createOffer(country, dailyPayment);
        CalculatedOffer calculatedOffer = offerService.calculateOffer(offer);
        return new DisplayOfferDTO(calculatedOffer);
    }
}
