package com.mercadolibre.mapper;

import com.mercadolibre.model.Sport;
import com.mercadolibre.model.SportDto;

public class SportMapper {

    public static SportDto sportToSportDto(Sport sport){
        SportDto sportDto = new SportDto();
        sportDto.setLevel(sport.getLevel());
        sportDto.setName(sport.getName());
        return sportDto;
    }

}
