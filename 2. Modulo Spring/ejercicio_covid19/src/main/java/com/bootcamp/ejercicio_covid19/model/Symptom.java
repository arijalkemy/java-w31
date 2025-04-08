package com.bootcamp.ejercicio_covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {
    private String code;
    private String name;
    private String severityLevel;
}
