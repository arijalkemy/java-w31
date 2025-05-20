package com.qa_tester.ejercicio_qa.service;

import com.qa_tester.ejercicio_qa.dto.TesterDto;

import java.util.List;

public interface ITesterService {
    TesterDto addTester(TesterDto testerDto);

    List<TesterDto> getAllTester();

    TesterDto findById(Long id);
}
