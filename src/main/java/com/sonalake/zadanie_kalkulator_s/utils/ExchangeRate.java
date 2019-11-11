package com.sonalake.zadanie_kalkulator_s.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
class ExchangeRate {
    String currencyCode;
    Integer rate;
    LocalDate lastUpdate;
}
