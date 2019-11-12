package com.sonalake.zadanie_kalkulator_s.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String isoCode;
    private Integer tax;
    private Integer fixedCosts;
    @OneToOne(cascade = CascadeType.ALL)
    private Currency currency;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "country")
    private List<Offer> offers;
}
