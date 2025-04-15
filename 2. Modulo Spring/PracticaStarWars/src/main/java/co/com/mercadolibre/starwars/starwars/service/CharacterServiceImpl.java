package co.com.mercadolibre.starwars.starwars.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.com.mercadolibre.starwars.starwars.dto.CharacterDto;
import co.com.mercadolibre.starwars.starwars.repository.CharacterRepository;

@Service
public class CharacterServiceImpl implements CharacterService{

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDto> findCharactersByName(String name) {
        List<CharacterDto> listOfCharacters = characterRepository.findAll().stream()
        .map(CharacterDto::mapCharacterToCharacterDto)
        .collect(Collectors.toList());

        return listOfCharacters.stream().
        filter(c -> c.getName().contains(name))
        .toList();
    }

    @Override
    public List<CharacterDto> findAll() {
        return characterRepository
        .findAll()
        .stream()
        .map(CharacterDto::mapCharacterToCharacterDto)
        .toList();
    }

    
}
