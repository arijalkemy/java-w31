package com.qa_tester.ejercicio_qa.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa_tester.ejercicio_qa.dto.TestCaseDto;
import com.qa_tester.ejercicio_qa.dto.TesterDto;
import com.qa_tester.ejercicio_qa.model.TestCase;
import com.qa_tester.ejercicio_qa.model.Tester;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GlobalMapping {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<TestCaseDto> testCaseToDtoList(List<TestCase> testCaseList){
        return testCaseList.stream()
                .map(GlobalMapping::entityToDto)
                .toList();
    }

    public static TestCase dtoToEntity(TestCaseDto testCaseDto){
        TestCase testCase = new TestCase();
        testCase.setId(testCaseDto.getId());
        testCase.setTested(testCaseDto.getTested());
        testCase.setNumber_of_tries(testCaseDto.getNumber_of_tries());
        testCase.setPassed(testCaseDto.getPassed());
        testCase.setDescription(testCaseDto.getDescription());
        testCase.setLast_update(testCaseDto.getLast_update());
        testCase.setTester(testCaseDto.getTester());
        return testCase;
    }

    public static TestCaseDto entityToDto(TestCase testCase){
        TestCaseDto testCaseDto = new TestCaseDto();
        testCaseDto.setId(testCase.getId());
        testCaseDto.setTested(testCase.getTested());
        testCaseDto.setNumber_of_tries(testCase.getNumber_of_tries());
        testCaseDto.setPassed(testCase.getPassed());
        testCaseDto.setDescription(testCase.getDescription());
        testCaseDto.setLast_update(testCase.getLast_update());
        testCaseDto.setTester(testCase.getTester());

        return testCaseDto;
    }

    public static Tester dtoToEntityTester(TesterDto testerDto){
        return new Tester(testerDto.getId(), testerDto.getName(), testerDto.getSeniority());
    }

    public static TesterDto entityToDtoTester(Tester tester){
        return new TesterDto(tester.getId(), tester.getName(), tester.getSeniority());
    }

    public static List<TesterDto> entityToDtoListTester(List<Tester> testerList){
        return testerList.stream().map(GlobalMapping::entityToDtoTester).toList();
    }
}
