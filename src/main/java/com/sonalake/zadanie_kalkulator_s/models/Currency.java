package com.sonalake.zadanie_kalkulator_s.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @OneToOne(cascade = CascadeType.ALL)
    private Country country;
}
