package com.sonalake.zadanie_kalkulator_s.controllers;

import com.sonalake.zadanie_kalkulator_s.DTOs.CountriesDTO;
import com.sonalake.zadanie_kalkulator_s.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class CountryController {
    private static final String GET_COUNTRIES_PATH = "/countries";

    private CountryService countryService;

    public CountryController(@Autowired CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(GET_COUNTRIES_PATH)
    public List<CountriesDTO> getCountries() {
        return countryService.getAllCountries().stream().map(CountriesDTO::new).collect(Collectors.toList());
    }
}
