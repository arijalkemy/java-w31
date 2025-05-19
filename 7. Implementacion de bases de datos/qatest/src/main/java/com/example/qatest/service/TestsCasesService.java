package com.example.qatest.service;

import com.example.qatest.model.dto.TestDTO;
import com.example.qatest.model.entity.TestCase;
import com.example.qatest.model.entity.TestExecutionResult;
import com.example.qatest.model.request.AddTestResultRequest;
import com.example.qatest.model.request.NewTestRequest;
import com.example.qatest.repository.TestCasesRepository;
import com.example.qatest.repository.TestExecutionResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TestsCasesService {

    private final TestCasesRepository testCasesRepository;
    private final TestExecutionResultRepository testExecutionResultRepository;

    private TestDTO mapTestCaseToTestDTO(TestCase testCase) {
        TestDTO dto = new TestDTO();
        dto.setId(testCase.getId());
        dto.setDescription(testCase.getDescription());

        List<TestExecutionResult> results = testCase.getExecutionResults();
        if (results != null && !results.isEmpty()) {
            dto.setTested(true);
            dto.setNumberOfTries(results.size());
            Optional<TestExecutionResult> latestResultOpt = results.stream()
                    .sorted(Comparator.comparing(TestExecutionResult::getExecutionTimestamp).reversed())
                    .findFirst();

            latestResultOpt.ifPresent(latestResult -> {
                dto.setPassed(latestResult.isPassed());
                dto.setLastUpdate(latestResult.getExecutionTimestamp());
            });
        } else {
            dto.setTested(false);
            dto.setNumberOfTries(0);
            dto.setPassed(false);
            dto.setLastUpdate(null);
        }

        return dto;
    }

    @Transactional // Good practice for write operations
    public TestDTO createTest(NewTestRequest newTest) {
        TestCase testCase = new TestCase();
        testCase.setDescription(newTest.getDescription());

        TestCase saved = testCasesRepository.save(testCase);
        return mapTestCaseToTestDTO(saved);
    }

    public List<TestDTO> getAllTests() {
        List<TestCase> testCases = testCasesRepository.findAll();

        return testCases.stream()
                .map(this::mapTestCaseToTestDTO)
                .toList();
    }

    public TestDTO getTestById(Long id) {
        Optional<TestCase> testCaseOpt = testCasesRepository.findById(id);

        return testCaseOpt
                .map(this::mapTestCaseToTestDTO) // Use the helper method if found
                .orElseThrow(() -> new RuntimeException("Test Case not found with id: " + id));
    }

    @Transactional
    public TestDTO updateTestById(Long id, NewTestRequest updatedTest) {
        Optional<TestCase> optionalTestCase = testCasesRepository.findById(id);

        if (optionalTestCase.isPresent()) {
            TestCase testCase = optionalTestCase.get();
            testCase.setDescription(updatedTest.getDescription());
            TestCase saved = testCasesRepository.save(testCase);
            return mapTestCaseToTestDTO(saved);
        } else {
            throw new RuntimeException("Test Case not found with id: " + id);
        }
    }

    @Transactional
    public void deleteTestCaseByID(Long id) {
        testCasesRepository.deleteById(id);
    }

    public List<TestDTO> getTestCasesAfter(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        List<TestCase> testCaseList = testCasesRepository.findTestCasesWithExecutionAfter(startOfDay);
        return testCaseList.stream()
                .map(this::mapTestCaseToTestDTO)
                .toList();
    }

    @Transactional
    public TestExecutionResult createTestExecutionResult(AddTestResultRequest request) {
        TestCase testCase = testCasesRepository.findById(request.getTestID())
                .orElseThrow(() -> new RuntimeException("Test Case not found with id: " + request.getTestID()));

        TestExecutionResult result = new TestExecutionResult();
        result.setTestCase(testCase);
        result.setPassed(request.isPassed());
        result.setExecutionTimestamp(LocalDateTime.now());

        return testExecutionResultRepository.save(result);
    }
}