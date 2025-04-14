package com.example.Covid.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {
    private int id;
    private String name;
    private String gravityLevel;
    private static int counter = 0;

    public Symptom(String name, String gravityLevel) {
        this.id = ++counter;
        this.name = name;
        this.gravityLevel = gravityLevel;
    }
}