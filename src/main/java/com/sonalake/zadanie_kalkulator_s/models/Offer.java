package com.sonalake.zadanie_kalkulator_s.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @NotNull
    @ManyToOne()
    private Country country;
    @Min(0)
    @NotNull
    private Float dailyPayment;
}
