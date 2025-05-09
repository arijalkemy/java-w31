package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @DisplayName("find debeia devolver una lista de personajes cuando query es valida")
    @Test
    public void find_ShouldReturnCharacterList_WhenQueryIsValid(){
        //arrange
        List<CharacterDTO> charactersExpected = getCharacterListSkywalker();
        when(characterRepository.findAllByNameContains("Skywalker")).thenReturn(charactersExpected);
        //act
        List<CharacterDTO> charactersActual = findService.find("Skywalker");
        //assert
        assertEquals(charactersExpected  , charactersActual );
        verify(characterRepository, times(1)).findAllByNameContains("Skywalker");
    }

    @DisplayName(" finde deberia devolver una lista vacia cuando query no corresponde a algun valor de la base de datos")
    @Test
    public void find_ShouldReturnEmptyList_WhenQueryIsUnknow(){
        //arrange
        List<CharacterDTO> charactersExpected = new ArrayList<>();
        when(characterRepository.findAllByNameContains("fer")).thenReturn(charactersExpected);
        //act
        List<CharacterDTO> charactersActual = findService.find("fer");
        //assert
        assertTrue(charactersActual.isEmpty());
        verify(characterRepository, times(1)).findAllByNameContains("fer");
    }



    public List<CharacterDTO> getCharacterListSkywalker() {
        List<CharacterDTO> characters = new ArrayList<>();

        CharacterDTO firstChar = new CharacterDTO();
        firstChar.setName("Luke Skywalker");
        firstChar.setHair_color("Blond");
        firstChar.setSkin_color("Fair");
        firstChar.setEye_color("Blue");
        firstChar.setBirth_year("19BBY");
        firstChar.setGender("Male");
        firstChar.setHomeworld("Tatooine");
        firstChar.setSpecies("Human");
        firstChar.setHeight(172);
        firstChar.setMass(77);

        CharacterDTO secondChar = new CharacterDTO();
        secondChar.setName("Darth Skywalker");
        secondChar.setHair_color("None");
        secondChar.setSkin_color("White");
        secondChar.setEye_color("Yellow");
        secondChar.setBirth_year("41.9BBY");
        secondChar.setGender("Male");
        secondChar.setHomeworld("Tatooine");
        secondChar.setSpecies("Human");
        secondChar.setHeight(202);
        secondChar.setMass(136);

        CharacterDTO thirdChar = new CharacterDTO();
        thirdChar.setName("Leia Skywalker");
        thirdChar.setHair_color("Brown");
        thirdChar.setSkin_color("Light");
        thirdChar.setEye_color("Brown");
        thirdChar.setBirth_year("19BBY");
        thirdChar.setGender("Female");
        thirdChar.setHomeworld("Alderaan");
        thirdChar.setSpecies("Human");
        thirdChar.setHeight(150);
        thirdChar.setMass(49);

        characters.add(firstChar);
        characters.add(secondChar);
        characters.add(thirdChar);

        return characters;
    }



    public List<CharacterDTO> getCharacterList() {
        List<CharacterDTO> characters = new ArrayList<>();

        CharacterDTO firstChar = new CharacterDTO();
        firstChar.setName("Luke Skywalker");
        firstChar.setHair_color("Blond");
        firstChar.setSkin_color("Fair");
        firstChar.setEye_color("Blue");
        firstChar.setBirth_year("19BBY");
        firstChar.setGender("Male");
        firstChar.setHomeworld("Tatooine");
        firstChar.setSpecies("Human");
        firstChar.setHeight(172);
        firstChar.setMass(77);

        CharacterDTO secondChar = new CharacterDTO();
        secondChar.setName("Darth Vader");
        secondChar.setHair_color("None");
        secondChar.setSkin_color("White");
        secondChar.setEye_color("Yellow");
        secondChar.setBirth_year("41.9BBY");
        secondChar.setGender("Male");
        secondChar.setHomeworld("Tatooine");
        secondChar.setSpecies("Human");
        secondChar.setHeight(202);
        secondChar.setMass(136);

        CharacterDTO thirdChar = new CharacterDTO();
        thirdChar.setName("Leia Organa");
        thirdChar.setHair_color("Brown");
        thirdChar.setSkin_color("Light");
        thirdChar.setEye_color("Brown");
        thirdChar.setBirth_year("19BBY");
        thirdChar.setGender("Female");
        thirdChar.setHomeworld("Alderaan");
        thirdChar.setSpecies("Human");
        thirdChar.setHeight(150);
        thirdChar.setMass(49);

        characters.add(firstChar);
        characters.add(secondChar);
        characters.add(thirdChar);

        return characters;
    }



}


/*
1- agregar la extension de mockito a la clase
@ExtendWith(MockitoExtension.class)

2- si es service mockear el repository y inject mock del servicio

3- la estructura del test

    @DisplayName(" ")
    @Test
    public void find_ShouldReturn_When(){
                //arrange
        //act
        //assert
    }

  4- pensar la cobertura

  5 - implementarla

 */