package com.mercadolibre.mapper;

import com.mercadolibre.model.Person;
import com.mercadolibre.model.Sport;
import com.mercadolibre.model.dto.PersonDto;
import com.mercadolibre.model.dto.SportDto;

public class SportMapper {

    public static SportDto sportToSportDto(Sport sport){
        SportDto sportDto = new SportDto();
        sportDto.setLevel(sport.getLevel());
        sport.setName(sport.getName());
        return sportDto;
    }

}
