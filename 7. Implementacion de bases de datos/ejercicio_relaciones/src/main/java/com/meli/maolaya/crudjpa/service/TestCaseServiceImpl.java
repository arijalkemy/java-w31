package com.meli.maolaya.crudjpa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import com.meli.maolaya.crudjpa.dto.TestCaseDto;
import com.meli.maolaya.crudjpa.model.TestCase;
import com.meli.maolaya.crudjpa.repository.ITestCaseRepository;
import com.meli.maolaya.crudjpa.util.TestCaseMapper;

import jakarta.transaction.Transactional;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    @Transactional
    public void saveTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = TestCaseMapper.fromDto(testCaseDto);
        testCaseRepository.save(testCase);
    }

    @Override
    @Transactional
    public List<TestCaseDto> getTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream()
                .map(testCase -> TestCaseMapper.fromEntity(testCase)).toList();
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow();
        return TestCaseMapper.fromEntity(testCase);
    }

    @Override
    public TestCaseDto saveTestCase(Long id, TestCaseDto testCaseDto) {
        TestCase testCase = TestCaseMapper.fromDto(testCaseDto);
        testCase.setIdCase(id);
        testCaseRepository.save(testCase);
        return TestCaseMapper.fromEntity(testCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseDto> getByDate(LocalDate date) {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream().filter(testCase -> testCase.getLastUpdate().isAfter(date))
                .map(testCase -> TestCaseMapper.fromEntity(testCase)).toList();
    }

}
