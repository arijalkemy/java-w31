package com.example.ejcovid19.service;

import lombok.Getter;

public class Symptom {
    @Getter
    private String code;
    @Getter
    private String name;
    @Getter
    private Integer level;

    public Symptom(String code, String name, Integer level) {
        this.code = code;
        this.name = name;
        this.level = level;
    }
}
