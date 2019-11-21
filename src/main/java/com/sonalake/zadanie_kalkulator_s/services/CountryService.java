package com.sonalake.zadanie_kalkulator_s.services;

import com.sonalake.zadanie_kalkulator_s.exceptions.CountryNotExist;
import com.sonalake.zadanie_kalkulator_s.models.Country;
import com.sonalake.zadanie_kalkulator_s.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(@Autowired CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     * Method fetching all countries from database.
     * @return all countries saved in db
     */
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    /**
     * Method allows to get country with specified id from database, if country do not exist it throw CountryNotExist
     * exception.
     * @param id requested country id
     * @return country with provided id or throw CountryNotExist
     * @throws CountryNotExist
     */
    public Country getCountryByIdOr404(Integer id) throws CountryNotExist {
        if(countryRepository.existsById(id))
            return countryRepository.findById(id).get();
        else
            throw new CountryNotExist(id);
    }
}
