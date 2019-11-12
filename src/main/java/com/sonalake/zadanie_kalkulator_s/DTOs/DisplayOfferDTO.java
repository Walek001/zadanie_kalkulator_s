package com.sonalake.zadanie_kalkulator_s.DTOs;

import com.sonalake.zadanie_kalkulator_s.services.CalculatedOffer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DisplayOfferDTO {
    private Float monthPayment;
    private String countryCode;

    public DisplayOfferDTO(CalculatedOffer calculatedOffer) {
        this.monthPayment = calculatedOffer.getNettoMonthPayment();
        this.countryCode = calculatedOffer.getCountry().getIsoCode();
    }
}
