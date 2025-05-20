package com.miniserie.miniserie_jpa.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniserie.miniserie_jpa.dto.MiniSerieDto;
import com.miniserie.miniserie_jpa.model.MiniSerie;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class GlobalMapper {
    private final ObjectMapper mapper = new ObjectMapper();

    public List<MiniSerieDto> miniSerieToDtoList(List<MiniSerie> miniSerieList){
        return miniSerieList.stream()
                .map(miniSerie -> mapper.convertValue(miniSerie,MiniSerieDto.class))
                .toList();
    }

    public MiniSerie dtoToEntity(MiniSerieDto miniSerieDto){
        return mapper.convertValue(miniSerieDto, MiniSerie.class);
    }

    public MiniSerieDto entityToDto (MiniSerie miniSerie){
        return mapper.convertValue(miniSerie, MiniSerieDto.class);
    }
}
