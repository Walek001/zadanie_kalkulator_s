package com.sonalake.zadanie_kalkulator_s.exceptions;

public class UnsupportedCurrencyCode extends Exception{
        public UnsupportedCurrencyCode(String currencyCode) {
                super("Can resolve provided currency code: " + currencyCode);
        }
}
