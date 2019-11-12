package com.sonalake.zadanie_kalkulator_s.models;

import com.sonalake.zadanie_kalkulator_s.utils.ExchangeRate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String currencyCode;
    private Float exchangeRate;
    private LocalDate lastUpdate;

    public Currency(ExchangeRate exchangeRate) {
        this.setCurrencyCode(exchangeRate.getCurrencyCode());
        this.setExchangeRate(exchangeRate.getRate());
        this.setLastUpdate(exchangeRate.getLastUpdate());
    }

    public Currency updateCurrency(ExchangeRate exchangeRate) {
        this.setCurrencyCode(exchangeRate.getCurrencyCode());
        this.setExchangeRate(exchangeRate.getRate());
        this.setLastUpdate(exchangeRate.getLastUpdate());
        return this;
    }

    private void setCurrencyCode() {}
}
