package com.sonalake.zadanie_kalkulator_s.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String isoCode;
    private Integer tax;
    private String currencyCode;
    private Integer fixedCosts;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "country")
    private List<Offer> offers;
}
