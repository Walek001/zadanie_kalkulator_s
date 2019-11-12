package com.sonalake.zadanie_kalkulator_s.repositories;

import com.sonalake.zadanie_kalkulator_s.models.Country;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface CountryRepository extends Repository<Country, Integer> {
}
