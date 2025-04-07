package com.bootcamp.sports.models;

import com.bootcamp.sports.dtos.SportDto;

public class Sport {
    private Long id;
    private String name;
    private Integer level;
    private static long idsCounter = 0;

    public Sport(String name, Integer level) {
        idsCounter++;
        this.id = idsCounter;
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public static Sport buildFromDto(SportDto sportDto) {
        return new Sport(sportDto.getName(), sportDto.getLevel());
    }

    @Override
    public String toString() {
        return "\nSport: " +
                "\nid= " + id +
                "\n\tname= " + name +
                "\n\tlevel= " + level;
    }
}
