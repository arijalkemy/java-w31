package org.example.personajesstarwars.service.mapper;

import org.example.personajesstarwars.dto.CharacterDTO;
import org.example.personajesstarwars.entity.CharacterEntity;

import java.util.List;
import java.util.stream.Collectors;

public class MapperManual {
    public static CharacterDTO toDto(CharacterEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CharacterDTO(
                entity.getName(),
                entity.getHeight() != null ? entity.getHeight().doubleValue() : 0.0,
                entity.getMass() != null ? entity.getMass().doubleValue() : 0.0,
                entity.getGender(),
                entity.getHomeworld(),
                entity.getSpecies()
        );
    }

    public static List<CharacterDTO> toDtoList(List<CharacterEntity> entities) {
        return entities.stream()
                .map(MapperManual::toDto)
                .collect(Collectors.toList());
    }
}
