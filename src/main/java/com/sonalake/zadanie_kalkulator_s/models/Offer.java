package com.sonalake.zadanie_kalkulator_s.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Country country;
    private Float dailyPayment;
}
