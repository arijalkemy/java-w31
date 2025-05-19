package com.mercadolibre.testersbd.service;

import com.mercadolibre.testersbd.dto.ResponseMessageDto;
import com.mercadolibre.testersbd.dto.TestCaseDto;
import com.mercadolibre.testersbd.exception.ConflictException;
import com.mercadolibre.testersbd.exception.NotFoundException;
import com.mercadolibre.testersbd.model.TestCase;
import com.mercadolibre.testersbd.utils.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mercadolibre.testersbd.repository.TestCaseRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;


    @Override
    public List<TestCaseDto> getTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        if (testCases.isEmpty()) {
            throw new NotFoundException("No se encontró ningun testcase en el sistema.");
        }
        return testCases.stream().map(TestMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TestCaseDto getTestCaseById(Long id_case) {
        Optional<TestCase> testCase = testCaseRepository.findById(id_case);
        if (testCase.isEmpty()) {
            throw new NotFoundException("No se encontro ningun testcase con ese id en el sistema.");
        }
        return TestMapper.toDto(testCase.get());
    }

    @Override
    public ResponseMessageDto saveTestCase(TestCase testCase) {
        testCaseRepository.save(testCase);
        return new ResponseMessageDto("TestCase guardado correctamente.");
    }

    @Override
    public ResponseMessageDto deleteTestCase(Long id_case) {
        if (!testCaseRepository.existsById(id_case)) {
            throw new NotFoundException("No se encontró ningún TestCase con ese id.");
        }
        testCaseRepository.deleteById(id_case);
        return new ResponseMessageDto("TestCase eliminado correctamente.");
    }

    @Override
    public ResponseMessageDto updateTestCase(Long id_case, TestCase testCase) {
        TestCase existingTestCase = testCaseRepository.findById(id_case)
                .orElseThrow(() -> new NotFoundException("No se encontró ningún TestCase con ese id."));

        existingTestCase.setDescription(testCase.getDescription());
        existingTestCase.setTested(testCase.getTested());
        existingTestCase.setPassed(testCase.getPassed());
        existingTestCase.setNumberOfTries(testCase.getNumberOfTries());

        testCaseRepository.save(existingTestCase);
        return new ResponseMessageDto("TestCase actualizado correctamente.");
    }

    @Override
    public List<TestCaseDto> getTestCasesUpdatedAfter(LocalDate lastUpdate) {
        List<TestCase> testCases = testCaseRepository.findByLastUpdateAfter(lastUpdate);
        if (testCases.isEmpty()) {
            throw new NotFoundException("No se encontraron test cases actualizados después de la fecha indicada.");
        }
        return testCases.stream().map(TestMapper::toDto).collect(Collectors.toList());
    }

}
