package com.qa_tester.ejercicio_qa.service.implementation;

import com.qa_tester.ejercicio_qa.dto.TestCaseDto;
import com.qa_tester.ejercicio_qa.dto.TesterDto;
import com.qa_tester.ejercicio_qa.exception.BadRequest;
import com.qa_tester.ejercicio_qa.model.TestCase;
import com.qa_tester.ejercicio_qa.repository.TestCaseRepository;
import com.qa_tester.ejercicio_qa.service.ITestCaseService;
import com.qa_tester.ejercicio_qa.service.ITesterService;
import com.qa_tester.ejercicio_qa.utils.GlobalMapping;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TestCaseService implements ITestCaseService {
    private final TestCaseRepository testCaseRepository;
    private final ITesterService testerService;

    @Override
    public TestCaseDto addTestCase(TestCaseDto testCaseDto){
        TestCase testCase = GlobalMapping.dtoToEntity(testCaseDto);
        if(testCaseRepository.findAll().stream()
                .anyMatch(tc -> tc.getDescription().equals(testCase.getDescription()))){
            throw new BadRequest("Already exist that test case");
        }

        TesterDto testerDto = testerService.findById(testCase.getTester().getId());
        testCase.setTester(GlobalMapping.dtoToEntityTester(testerDto));

        testCaseRepository.save(testCase);
        return GlobalMapping.entityToDto(testCase);
    }

    @Override
    public List<TestCaseDto> getAllTest(){
        List<TestCase> testCaseList = testCaseRepository.findAll();
        if(testCaseList.isEmpty()){
            throw new BadRequest("No test cases found");
        }

        return GlobalMapping.testCaseToDtoList(testCaseList);
    }

    @Override
    public TestCaseDto getTestCaseById(Long testCaseId){
        TestCase testCase = testCaseRepository.findById(testCaseId)
                .orElseThrow(()-> new BadRequest("No test case found with that id"));

        return GlobalMapping.entityToDto(testCase);
    }

    @Override
    public TestCaseDto updateTestCase(Long testCaseId, TestCaseDto testCaseDto){
        TestCase testCase = testCaseRepository.findById(testCaseId)
                .orElseThrow(() -> new BadRequest("No test case found with that id"));

        testCase.setDescription(testCaseDto.getDescription());
        testCase.setLast_update(testCaseDto.getLast_update());
        testCase.setNumber_of_tries(testCaseDto.getNumber_of_tries());
        testCase.setPassed(testCaseDto.getPassed());
        testCase.setTested(testCaseDto.getTested());
        TesterDto testerDto = testerService.findById(testCaseDto.getTester().getId());
        testCase.setTester(GlobalMapping.dtoToEntityTester(testerDto));

        testCaseRepository.save(testCase);

        return GlobalMapping.entityToDto(testCase);
    }

    @Override
    public void deleteTestCase(Long testCaseId){
        testCaseRepository.findById(testCaseId)
                .orElseThrow(() -> new BadRequest("No test case found with that id"));

        testCaseRepository.deleteById(testCaseId);
    }

    @Override
    public List<TestCaseDto> getByDate(LocalDate lastUpdate){
        List<TestCase> testCaseList = testCaseRepository.findAll()
                .stream()
                .filter(testCase -> testCase.getLast_update().isAfter(lastUpdate)).toList();

        if(testCaseList.isEmpty()){
            throw new BadRequest("No test cases found for that date");
        }

        return GlobalMapping.testCaseToDtoList(testCaseList);
    }
}
