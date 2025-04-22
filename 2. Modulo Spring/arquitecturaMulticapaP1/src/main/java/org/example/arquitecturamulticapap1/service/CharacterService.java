package org.example.arquitecturamulticapap1.service;

import org.example.arquitecturamulticapap1.dto.CharacterDto;

import java.util.List;

public interface CharacterService {
    List<CharacterDto> getCharacter(String name);
}
