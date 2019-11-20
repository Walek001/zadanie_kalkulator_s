package com.sonalake.zadanie_kalkulator_s.services;

import com.sonalake.zadanie_kalkulator_s.configs.WorkingDaysConfig;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import com.sonalake.zadanie_kalkulator_s.models.Country;
import com.sonalake.zadanie_kalkulator_s.models.Offer;
import com.sonalake.zadanie_kalkulator_s.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private OfferRepository offerRepository;
    private CurrencyService currencyService;
    private WorkingDaysConfig workingDaysConfig;


    public OfferService(
            @Autowired OfferRepository offerRepository,
            @Autowired CurrencyService currencyService,
            @Autowired WorkingDaysConfig workingDaysConfig) {
        this.offerRepository = offerRepository;
        this.currencyService = currencyService;
        this.workingDaysConfig = workingDaysConfig;
    }

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public Offer createOffer(Country country, Integer dailyPayment) {
        Offer offer = new Offer();
        offer.setCountry(country);
        offer.setDailyPayment(dailyPayment.floatValue()/100f);
        return offerRepository.save(offer);
    }

    public CalculatedOffer calculateOffer(Offer offer) throws UnsupportedCurrencyCode {
        CalculatedOffer calculatedOffer = new CalculatedOffer();
        calculatedOffer.setCountry(offer.getCountry());
        Float nettoPayment = ((offer.getDailyPayment()*workingDaysConfig.getCount())-offer.getCountry().getFixedCosts())*((100-(offer.getCountry().getTax()))/100f);
        Float nettoPaymentPLN = nettoPayment*(currencyService.getCurrentCurrencyRateFor(offer.getCountry())).getExchangeRate();
        calculatedOffer.setNettoMonthPayment(nettoPaymentPLN);
        return calculatedOffer;
    }
}
