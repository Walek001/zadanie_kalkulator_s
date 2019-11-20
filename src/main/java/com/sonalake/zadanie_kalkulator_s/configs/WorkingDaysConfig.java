package com.sonalake.zadanie_kalkulator_s.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="working-days")
@Getter
@Setter
public class WorkingDaysConfig {
    private Integer count;
}
