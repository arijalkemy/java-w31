package com.example.qatesters.service;

import com.example.qatesters.dto.ResponseDTO;
import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.exception.NotFoundException;
import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.TestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    private final TestCaseRepository testCaseRepo;
    private final ObjectMapper mapper;

    public TestCaseService(TestCaseRepository testCaseRepo) {
        this.testCaseRepo = testCaseRepo;
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public List<TestCaseDTO> getTestCases() {
        List<TestCase> testCaseList = testCaseRepo.findAll();
        return testCaseList.stream()
                .map(t -> mapper.convertValue(t, TestCaseDTO.class))
                .toList();
    }

    @Override
    public TestCaseDTO saveTestCase(TestCaseDTO testCase) {
        TestCase newTestCase = mapper.convertValue(testCase, TestCase.class);
        testCaseRepo.save(newTestCase);
        return mapper.convertValue(newTestCase, TestCaseDTO.class);
    }

    @Override
    public ResponseDTO deleteTestCase(Long id) {
        testCaseRepo.deleteById(id);
        return new ResponseDTO( "Se borro exitosamente el test case de id: " + id);
    }

    @Override
    public TestCaseDTO modifyTestCase(Long id, TestCaseDTO modifyTestCase) {
        TestCase testCase = testCaseRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el test case a modificar"));
        testCase.setTested(modifyTestCase.getTested());
        testCase.setNumberOfTries(modifyTestCase.getNumberOfTries());
        testCase.setPassed(modifyTestCase.getPassed());
        testCase.setLastUpdate(modifyTestCase.getLastUpdate());
        testCase.setDescription(modifyTestCase.getDescription());
        testCaseRepo.save(testCase);
        return mapper.convertValue(testCase, TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO getTestCaseById(Long id) {
        TestCase testCase = testCaseRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontro el test case"));
        return mapper.convertValue(testCase, TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> getTestCasesByDate(LocalDate date) {
        List<TestCase> testCaseList = testCaseRepo.findAll();
        return testCaseList.stream()
                .filter(t -> t.getLastUpdate().isAfter(date))
                .map(t -> mapper.convertValue(t, TestCaseDTO.class))
                .toList();
    }
}
