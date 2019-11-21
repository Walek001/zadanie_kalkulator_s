package com.sonalake.zadanie_kalkulator_s.controllers;

import com.sonalake.zadanie_kalkulator_s.DTOs.DailyPaymentDTO;
import com.sonalake.zadanie_kalkulator_s.DTOs.DisplayOfferDTO;
import com.sonalake.zadanie_kalkulator_s.exceptions.CountryNotExist;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import com.sonalake.zadanie_kalkulator_s.models.Offer;
import com.sonalake.zadanie_kalkulator_s.services.CalculatedOffer;
import com.sonalake.zadanie_kalkulator_s.services.OfferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "Api for consuming and creating offers")
@RestController
@RequestMapping("api")
public class OfferController {
    static final String OFFERS_PATH = "/offers";

    private OfferService offerService;

    public OfferController(@Autowired OfferService offerService) {
        this.offerService = offerService;
    }

    @ApiOperation(value = "Create and calculate new offer", nickname = "Create offer")
    @PostMapping(OFFERS_PATH)
    public DisplayOfferDTO createOffer(@ApiParam(value = "ID of the country which the offer concerns.") @RequestParam  Integer country,
                                       @ApiParam(value = "Daily payment multiplied by 100") @RequestBody DailyPaymentDTO dailyPaymentDTO)
            throws CountryNotExist, UnsupportedCurrencyCode {
        Offer offer = offerService.createOffer(country, dailyPaymentDTO.getDailyPayment());
        CalculatedOffer calculatedOffer = offerService.calculateOffer(offer);
        return new DisplayOfferDTO(calculatedOffer);
    }
}
