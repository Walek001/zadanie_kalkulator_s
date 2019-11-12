package com.sonalake.zadanie_kalkulator_s.repositories;

import com.sonalake.zadanie_kalkulator_s.models.Offer;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface OfferRepository extends Repository<Offer, Integer> {
    List<Offer> findAll();

    Offer save(Offer result);
}
