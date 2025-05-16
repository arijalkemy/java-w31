package com.example.qatest.service;

import com.example.qatest.model.dto.TestDTO;
import com.example.qatest.model.entity.TestCase;
import com.example.qatest.model.request.NewTestRequest;
import com.example.qatest.repository.TestCasesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TestsCasesService implements ITestsCasesService {

    TestCasesRepository repository;
    ObjectMapper mapper;

    @Override
    public TestDTO createTest(NewTestRequest newTest) {
        TestCase test = mapper.convertValue(newTest, TestCase.class);
        TestCase saved = repository.save(test);
        return mapper.convertValue(saved, TestDTO.class);
    }

    @Override
    public List<TestDTO> getAllTests() {
        return repository.findAll().stream().map(t -> mapper.convertValue(t, TestDTO.class)).toList();
    }

    @Override
    public TestDTO getTestById(Long id) {
        return repository.findById(id).map(t -> mapper.convertValue(t, TestDTO.class)).orElseThrow();
    }

    @Override
    public TestDTO updateTestById(Long id, NewTestRequest updatedTest) {
        return repository.findById(id).map(
                testCase -> {
                    testCase.setDescription(updatedTest.getDescription());
                    testCase.setLast_update(updatedTest.getLast_update());
                    testCase.setTested(updatedTest.getTested());
                    testCase.setPassed(updatedTest.getPassed());
                    testCase.setNumber_of_tries(updatedTest.getNumber_of_tries());
                    return mapper.convertValue(testCase, TestDTO.class);
                }
        ).orElseThrow();
    }

    @Override
    public void deleteTestCaseByID(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TestDTO> getTestCasesAfter(LocalDate lastUpdate) {
        List<TestCase> testCaseList = repository.findAll()
                .stream()
                .filter(testCase -> testCase.getLast_update().isAfter(lastUpdate)).toList();

        return testCaseList.stream().map(t -> mapper.convertValue(t, TestDTO.class)).toList();
    }
}
