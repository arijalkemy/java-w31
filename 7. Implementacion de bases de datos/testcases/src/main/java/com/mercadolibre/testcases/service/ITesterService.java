package com.mercadolibre.testcases.service;

import com.mercadolibre.testcases.dto.TesterDto;

import java.util.List;

public interface ITesterService {
    TesterDto save(TesterDto testerDto);
    List<TesterDto> getAll();
}
