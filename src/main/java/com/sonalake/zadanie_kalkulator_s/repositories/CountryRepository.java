package com.sonalake.zadanie_kalkulator_s.repositories;

import com.sonalake.zadanie_kalkulator_s.models.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
    List<Country> findAll();
}
