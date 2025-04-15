package co.com.mercadolibre.diecinueve.coviddiecinueve.services;

import java.util.List;

import co.com.mercadolibre.diecinueve.coviddiecinueve.dto.PersonDto;

public interface PersonService{

    List<PersonDto> findCommonSymptomsOnPersonOverSixtyYears();
}
