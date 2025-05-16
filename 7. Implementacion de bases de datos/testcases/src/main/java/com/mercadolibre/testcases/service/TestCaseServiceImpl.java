package com.mercadolibre.testcases.service;

import com.mercadolibre.testcases.dto.TestCaseDto;
import com.mercadolibre.testcases.model.TestCase;
import com.mercadolibre.testcases.repository.ITestCaseRepository;
import com.mercadolibre.testcases.util.TestCaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDto save(TestCaseDto testCaseDto) {
        TestCase testCase = testCaseRepository.save(TestCaseMapper.toTestCase(testCaseDto));
        return TestCaseMapper.toTestCaseDto(testCase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDto> findAll() {
        return TestCaseMapper.toTestCasesDto(testCaseRepository.findAll());
    }

    @Override
    public TestCaseDto findById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        return testCase != null ? TestCaseMapper.toTestCaseDto(testCase) : null;
    }

    @Override
    public TestCaseDto update(TestCaseDto testCaseDto) {
        TestCase testCase = testCaseRepository.findById(testCaseDto.getId()).orElse(null);
        if (testCase != null) {
            testCase.setDescription(testCaseDto.getDescription());
            testCase.setPassed(testCaseDto.getPassed());
            testCase.setTested(testCaseDto.getTested());
            testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
            testCase.setLastUpdate(LocalDate.now());
            TestCase savedTestCase = testCaseRepository.save(testCase);
            return TestCaseMapper.toTestCaseDto(savedTestCase);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseDto> findAllByLastUpdate(String lastUpdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<TestCase> testCases = testCaseRepository
                .findAllByLastUpdateIsAfter(LocalDate.parse(lastUpdate, formatter));
        return TestCaseMapper.toTestCasesDto(testCases);
    }

//    @Override
//    public List<TestCaseDto> findByFilter(Boolean passed, Boolean tested, Integer numberOfTries, String lastUpdate) {
//        List<TestCase> testCases =;
//        if (passed != null) {
//            testCases = testCases.stream().filter(t -> passed.equals(t.getPassed())).toList();
//        }
//    }


}
