package com.sonalake.zadanie_kalkulator_s.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
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
    @NotNull
    private Integer tax;
    @NotNull
    private Integer fixedCosts;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Currency currency;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "country")
    private List<Offer> offers = Collections.emptyList();
}
