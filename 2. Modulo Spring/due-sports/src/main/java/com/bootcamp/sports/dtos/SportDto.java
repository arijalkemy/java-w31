package com.bootcamp.sports.dtos;

import com.bootcamp.sports.models.Sport;

import java.io.Serializable;

public class SportDto implements Serializable {
    private Long id;
    private String name;
    private Integer level;

    private SportDto(Long id, String name, Integer level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public static SportDto buildFromSport(Sport sport) {
        return new SportDto(sport.getId(), sport.getName(), sport.getLevel());
    }
}
