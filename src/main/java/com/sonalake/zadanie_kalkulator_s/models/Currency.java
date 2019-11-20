package com.sonalake.zadanie_kalkulator_s.models;

import com.sonalake.zadanie_kalkulator_s.utils.ExchangeRate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @NotNull
    private String currencyCode;
    @NotNull
    private Float exchangeRate;
    @NotNull
    private LocalDate lastUpdate;

    public Currency(ExchangeRate exchangeRate) {
        this.currencyCode = exchangeRate.getCurrencyCode();
        this.exchangeRate = exchangeRate.getRate();
        this.lastUpdate = exchangeRate.getLastUpdate();
    }

    public Currency updateCurrency(ExchangeRate exchangeRate) {
        this.currencyCode = exchangeRate.getCurrencyCode();
        this.exchangeRate = exchangeRate.getRate();
        this.lastUpdate = exchangeRate.getLastUpdate();
        return this;
    }

    private void setCurrencyCode() {}
}
