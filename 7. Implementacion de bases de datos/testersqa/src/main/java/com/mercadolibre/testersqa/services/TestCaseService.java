package com.mercadolibre.testersqa.services;

import com.mercadolibre.testersqa.dto.TestCaseDto;
import com.mercadolibre.testersqa.entity.TestCase;
import com.mercadolibre.testersqa.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService implements ITestCaseService{
    @Autowired
    ITestCaseRepository testCaseRepository;
    @Override
    public TestCase create(TestCase testCaseDto) {
        return testCaseRepository.save(testCaseDto);
    }
}
