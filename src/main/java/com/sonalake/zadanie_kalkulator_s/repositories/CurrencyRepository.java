package com.sonalake.zadanie_kalkulator_s.repositories;

import com.sonalake.zadanie_kalkulator_s.models.Currency;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface CurrencyRepository extends Repository<Currency, Integer> {
    Currency save(Currency currency);
}
