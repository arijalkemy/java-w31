package com.example.jpa.service;

import com.example.jpa.dto.TestCaseDto;
import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.TestCase;
import com.example.jpa.repository.ITestCaseRepository;
import com.example.jpa.util.TestCaseSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public void save(TestCaseDto testCaseDto) {
        TestCase testCase = TestCase.builder()
                .description(testCaseDto.getDescription())
                .tested(testCaseDto.getTested())
                .passed(testCaseDto.getPassed())
                .numberOfTries(testCaseDto.getNumberOfTries())
                .build();

        testCaseRepository.save(testCase);
    }

    @Override
    public TestCaseDto getById(Long id) {
         TestCase testCase = findById(id);

        return TestCaseDto.builder()
                .id(testCase.getIdCase())
                .description(testCase.getDescription())
                .tested(testCase.isTested())
                .passed(testCase.isPassed())
                .numberOfTries(testCase.getNumberOfTries())
                .lastUpdate(testCase.getLastUpdate())
                .build();
    }

    @Override
    public void updateById(TestCaseDto testCaseDto, Long id) {
        TestCase testCase = findById(id);

        testCase.setDescription(testCaseDto.getDescription());
        testCase.setTested(testCaseDto.getTested());
        testCase.setPassed(testCaseDto.getPassed());
        testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        testCaseRepository.save(testCase);
    }

    @Override
    public void deleteById(Long id) {
        testCaseRepository.delete(findById(id));
    }

    @Override
    public List<TestCaseDto> findAllByFilters(Boolean passed, Boolean tested, Integer numberOfTries, String lastUpdate){
        LocalDate lastUpdateDate = lastUpdate==null?LocalDate.now():LocalDate.parse(lastUpdate);

        Specification<TestCase> specification = Specification.where(TestCaseSpecification.hasPassed(passed))
                .and(TestCaseSpecification.hasTested(tested))
                .and(TestCaseSpecification.hasLastUpdate(lastUpdateDate))
                .and(TestCaseSpecification.hasNumberOfTries(numberOfTries));

        List<TestCase> testCases = testCaseRepository.findAll(specification);

        if (testCases.isEmpty()){
            throw new ResourceNotFoundException("No test cases found with the given filters.");
        }

        return testCases.stream()
                .map(tc -> TestCaseDto.builder()
                        .id(tc.getIdCase())
                        .description(tc.getDescription())
                        .tested(tc.isTested())
                        .passed(tc.isPassed())
                        .numberOfTries(tc.getNumberOfTries())
                        .lastUpdate(tc.getLastUpdate())
                        .build())
                .toList();
    }

    private TestCase findById(Long id) {
         return testCaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TestCase with ID " + id + " not found"));
    }
}
