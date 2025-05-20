package com.mercadolibre.casosdeprueba.service;

import com.mercadolibre.casosdeprueba.dto.TestCaseDto;
import com.mercadolibre.casosdeprueba.mapper.TestCaseMapper;
import com.mercadolibre.casosdeprueba.model.TestCase;
import com.mercadolibre.casosdeprueba.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {

    ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public String createTestCase(TestCaseDto testCase) {
        TestCase testCaseEntity = TestCaseMapper.toTestCase(testCase);
        testCaseRepository.save(testCaseEntity);
        return "TestCase created";
    }

    @Override
    public List<TestCaseDto> getTestCases() {
        return testCaseRepository.findAll().stream().map(TestCaseMapper::toTestCaseDto).toList();
    }

    @Override
    public List<TestCaseDto> getTestCasesByLastUpdate(String lastUpdate) {
        LocalDate localDate = LocalDate.parse(lastUpdate);
        return testCaseRepository.findAll().stream().filter(t -> t.getLast_update().isAfter(localDate)).map(TestCaseMapper::toTestCaseDto).toList();
    }

    @Override
    public TestCaseDto getTestCasebyId(Long id) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        return testCase.map(TestCaseMapper::toTestCaseDto).orElse(null);
    }

    @Override
    public TestCaseDto updateTestCaseService(Long id, TestCaseDto testCase) {
        Optional<TestCase> testCaseToEdit = testCaseRepository.findById(id);
        if (testCaseToEdit.isPresent()) {
            TestCase editedTestCase = edit(testCaseToEdit.get(), testCase);
            return TestCaseMapper.toTestCaseDto(testCaseRepository.save(editedTestCase));
        }
        return null;
    }

    private TestCase edit(TestCase testCase, TestCaseDto testCaseDto) {
        testCase.setDescription(testCaseDto.getDescription());
        testCase.setTested(testCaseDto.getTested());
        testCase.setPassed(testCaseDto.getPassed());
        testCase.setNumber_of_tries(testCaseDto.getNumber_of_tries());
        return testCase;
    }

    @Override
    public String deleteTestCaseService(Long id) {
        testCaseRepository.deleteById(id);
        return "Test Case deleted";
    }
}
