package co.com.mercadolibre.practicadeportistas.practicadeportistas.service;


import java.util.List;

import co.com.mercadolibre.practicadeportistas.practicadeportistas.dto.SportDto;

public interface SportService {

    List<SportDto> getSports();
    SportDto findSportByName(String sportName);
}
