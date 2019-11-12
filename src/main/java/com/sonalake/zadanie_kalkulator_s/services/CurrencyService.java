package com.sonalake.zadanie_kalkulator_s.services;

import com.sonalake.zadanie_kalkulator_s.exceptions.ServerNotRespondingException;
import com.sonalake.zadanie_kalkulator_s.exceptions.UnsupportedCurrencyCode;
import com.sonalake.zadanie_kalkulator_s.models.Country;
import com.sonalake.zadanie_kalkulator_s.models.Currency;
import com.sonalake.zadanie_kalkulator_s.repositories.CurrencyRepository;
import com.sonalake.zadanie_kalkulator_s.utils.CurrenciesExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CurrencyService {
    private CurrencyRepository currencyRepository;
    private CurrenciesExchange currenciesExchange;
    public CurrencyService(@Autowired CurrencyRepository currencyRepository, @Autowired CurrenciesExchange currenciesExchange) {
        this.currencyRepository = currencyRepository;
        this.currenciesExchange = currenciesExchange;
    }

    public Currency getCurrentCurrencyRateFor(Country country) throws UnsupportedCurrencyCode {
        Currency currency = country.getCurrency();
        try {
            if (LocalDate.now().isAfter(currency.getLastUpdate())) {
                currency.updateCurrency(currenciesExchange.getCurrencyExchangeRate(currency.getCurrencyCode()));
                currency = currencyRepository.save(currency);
            }
            return currency;
        } catch (ServerNotRespondingException e) {
            return currency;
        }
    }
}
