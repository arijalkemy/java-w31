package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TestCaseDto;
import com.example.demo.model.TestCase;
import com.example.demo.repository.ITestCaseRepository;

@Service
public class TestCaseService implements ITestCaseService{
    
    ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }
    
    public TestCaseDto createNewTestCase(TestCaseDto testCaseDto){
        TestCase testCase = testCaseDto.toEntity();
        testCaseRepository.save(testCase);
        testCaseDto.setIdCase(testCase.getIdCase());
        return testCaseDto;
    }

    public List<TestCaseDto> getAllTestCases(){
        List<TestCase> listTestCase = testCaseRepository.findAll();
        return listTestCase.stream().map(v -> TestCaseDto.toDto(v)).toList();
    }

    public TestCaseDto getTestCaseById(Long id){
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        return TestCaseDto.toDto(testCase);
    }

    public void deleteTestCaseById(Long id){
        testCaseRepository.deleteById(id);
    }

    public TestCaseDto updateTestCaseById(Long id, TestCaseDto testCaseDto){
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new RuntimeException("TestCase no encontrado"));

        if (testCaseDto.getDescription() != null)
            testCase.setDescription(testCaseDto.getDescription());
        if (testCaseDto.getTested() != null)
            testCase.setTested(testCaseDto.getTested());
        if (testCaseDto.getPassed() != null)
            testCase.setPassed(testCaseDto.getPassed());
        if (Integer.valueOf(testCaseDto.getNumberOfTries()) != null)
            testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        if (testCaseDto.getLastUpdate() != null)
            testCase.setLastUpdate(testCaseDto.getLastUpdate());

        testCaseRepository.save(testCase);
        return TestCaseDto.toDto(testCase);
    }

    public List<TestCaseDto> findTestCasesUpdatedAfter(LocalDate date){
        List<TestCase> listFilteredTaseCase = testCaseRepository.findAll();
        return listFilteredTaseCase.stream().filter(v -> v.getLastUpdate().isAfter(date)).map(v -> TestCaseDto.toDto(v)).toList();
    }
}
