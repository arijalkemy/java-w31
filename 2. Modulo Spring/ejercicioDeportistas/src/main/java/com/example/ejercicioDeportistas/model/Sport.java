package com.example.ejercicioDeportistas.model;

public class Sport {
    private String name;
    private Integer level;


    public Sport(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
