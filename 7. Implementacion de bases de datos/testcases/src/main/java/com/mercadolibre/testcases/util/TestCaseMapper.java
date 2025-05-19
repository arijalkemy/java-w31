package com.mercadolibre.testcases.util;

import com.mercadolibre.testcases.dto.TestCaseDto;
import com.mercadolibre.testcases.model.TestCase;
import com.mercadolibre.testcases.model.Tester;
import com.mercadolibre.testcases.repository.ITesterRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TestCaseMapper {

    private final ITesterRepository testerRepository;

    public TestCaseMapper(ITesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }

    public static TestCaseDto toTestCaseDto(TestCase testCase) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new TestCaseDto(
                testCase.getId(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate().format(formatter),
                testCase.getTester() != null ? testCase.getTester().getId() : null
        );
    }

    public TestCase toTestCase(TestCaseDto dto) {
        TestCase testCase = new TestCase();
        testCase.setDescription(dto.getDescription());
        testCase.setTested(dto.getTested());
        testCase.setPassed(dto.getPassed());
        testCase.setNumberOfTries(dto.getNumberOfTries());
        testCase.setLastUpdate(dto.getLastUpdate() != null
                && !dto.getLastUpdate().isEmpty()
                ? LocalDate.parse(dto.getLastUpdate())
                : LocalDate.now());

        Tester tester = testerRepository.findById(dto.getTesterId())
                .orElseThrow(() -> new RuntimeException("Tester not found"));
        testCase.setTester(tester);
        return testCase;
    }

    public static List<TestCaseDto> toTestCasesDto(List<TestCase> testCases) {
        return testCases.stream().map(TestCaseMapper::toTestCaseDto).toList();
    }
}
