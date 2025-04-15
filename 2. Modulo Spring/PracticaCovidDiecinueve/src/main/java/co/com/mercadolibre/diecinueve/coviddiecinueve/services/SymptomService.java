package co.com.mercadolibre.diecinueve.coviddiecinueve.services;

import java.util.List;

import co.com.mercadolibre.diecinueve.coviddiecinueve.dto.SymptomDto;

public interface SymptomService{

    List<SymptomDto> findAllSymptoms();
    SymptomDto findSypmtomSeverityByName(String name);
}
