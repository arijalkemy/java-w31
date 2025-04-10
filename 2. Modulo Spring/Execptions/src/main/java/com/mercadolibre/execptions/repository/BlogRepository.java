package com.mercadolibre.execptions.repository;

import com.mercadolibre.execptions.dto.entryblogdto;

import java.util.Collection;

public interface BlogRepository {

    entryblogdto save(entryblogdto blogEntry);
    entryblogdto findById(int id);
    Collection<entryblogdto> findAll();
    boolean existsById(int id);
}
