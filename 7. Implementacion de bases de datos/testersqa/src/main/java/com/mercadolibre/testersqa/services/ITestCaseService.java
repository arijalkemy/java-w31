package com.mercadolibre.testersqa.services;

import com.mercadolibre.testersqa.dto.TestCaseDto;
import com.mercadolibre.testersqa.entity.TestCase;
import org.springframework.stereotype.Service;

@Service
public interface ITestCaseService {

    public TestCase create(TestCase testCaseDto);
}
