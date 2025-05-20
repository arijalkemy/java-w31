package com.bootcamp.obrasliterarias_nosql.mapper;

import com.bootcamp.obrasliterarias_nosql.dto.LiteraryWorkDTO;
import com.bootcamp.obrasliterarias_nosql.model.LiteraryWork;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LiteraryWorkMapper {
    public static LiteraryWorkDTO toDTO(LiteraryWork work) {
        return new LiteraryWorkDTO(
                work.getId(),
                work.getName(),
                work.getAuthor(),
                work.getNumberPages(),
                work.getEditorial(),
                work.getYear()
        );
    }

    public static LiteraryWork toEntity(LiteraryWorkDTO dto) {
        return new LiteraryWork(
                dto.getId(),
                dto.getName(),
                dto.getAuthor(),
                dto.getNumberPages(),
                dto.getEditorial(),
                dto.getYear()
        );
    }

    public static List<LiteraryWorkDTO> toDTOList(List<LiteraryWork> docs) {
        return docs.stream()
                .map(LiteraryWorkMapper::toDTO)
                .collect(Collectors.toList());
    }
}

