package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.TestCaseDto;
import com.mercadolibre.qatesters.exception.NotFoundException;
import com.mercadolibre.qatesters.model.TestCase;
import com.mercadolibre.qatesters.repository.TestCaseRepository;
import com.mercadolibre.qatesters.utils.MapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class TestCaseServiceImpl implements ITestCaseService{

    private TestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDto createTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = MapperUtil.toEntity(testCaseDto);
        testCase = testCaseRepository.save(testCase);
        return MapperUtil.toDto(testCase);
    }

    @Override
    public List<TestCaseDto> getTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream().map(MapperUtil::toDto).toList();
    }

    @Override
    public TestCaseDto getTestCase(Long id) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        if(testCaseOptional.isEmpty()){
            throw new NotFoundException("Test case with id " + id + " not found");
        }
        return MapperUtil.toDto(testCaseOptional.get());
    }

    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        if(testCaseOptional.isEmpty()){
            throw new NotFoundException("Test case with id " + id + " not found");
        }
        TestCase testCase = testCaseOptional.get();
        testCase.setDescription(testCaseDto.getDescription());
        testCase.setLastUpdate(testCaseDto.getLastUpdate());
        testCase.setPassed(testCaseDto.getPassed());
        testCase.setTested(testCaseDto.getTested());
        testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        TestCase updatedTestCase = testCaseRepository.save(testCase);
        return MapperUtil.toDto(updatedTestCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        if(testCaseOptional.isEmpty()){
            throw new NotFoundException("Test case not found");
        }
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseDto> getTestCasesUpdatedAfter(LocalDate lastUpdate) {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream().filter(t -> t.getLastUpdate().isAfter(lastUpdate)).map(MapperUtil::toDto).toList();
    }
}
