package com.sonalake.zadanie_kalkulator_s.DTOs;

import com.sonalake.zadanie_kalkulator_s.models.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CountriesDTO {
    private String isoCode;
    private Integer id;

    public CountriesDTO(Country country) {
        this.isoCode = country.getIsoCode();
        this.id = country.getID();
    }
}
