package com.bootcamp.miniseries.util;

import com.bootcamp.miniseries.dto.MiniSerieDto;
import com.bootcamp.miniseries.model.MiniSerie;
import org.springframework.stereotype.Component;

@Component
public class MiniSerieMapper {
    public static MiniSerie toMiniSerie(MiniSerieDto miniSerieDto) {
        return new MiniSerie(
                miniSerieDto.getId(),
                miniSerieDto.getName(),
                miniSerieDto.getRating(),
                miniSerieDto.getAmountOfAwards()
        );
    }

    public static MiniSerieDto toMiniSerieDto(MiniSerie miniSerie) {
        return new MiniSerieDto(
                miniSerie.getId(),
                miniSerie.getName(),
                miniSerie.getRating(),
                miniSerie.getAmountOfAwards()
        );
    }
}
