package com.example.qatest.service;

import com.example.qatest.model.dto.TestDTO;
import com.example.qatest.model.request.NewTestRequest;

import java.time.LocalDate;
import java.util.List;

public interface ITestsCasesService {
    TestDTO createTest(NewTestRequest newTest);

    List<TestDTO> getAllTests();

    TestDTO getTestById(Long id);

    TestDTO updateTestById(Long id, NewTestRequest updatedTest);

    void deleteTestCaseByID(Long id);

    List<TestDTO> getTestCasesAfter(LocalDate lastUpdate);
}
