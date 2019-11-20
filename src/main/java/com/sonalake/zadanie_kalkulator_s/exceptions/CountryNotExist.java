package com.sonalake.zadanie_kalkulator_s.exceptions;

public class CountryNotExist extends Exception {
    public CountryNotExist(Integer id) {
        super("Country with id " + id + " don\'t exist.");
    }
}
