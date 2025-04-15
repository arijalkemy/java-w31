package co.com.mercadolibre.practicadeportistas.practicadeportistas.service;

import java.util.List;

import co.com.mercadolibre.practicadeportistas.practicadeportistas.dto.PersonDto;

public interface PersonService {
    List<PersonDto> findSportsPersons();
}
