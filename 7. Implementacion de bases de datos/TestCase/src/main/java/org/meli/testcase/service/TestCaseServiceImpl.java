package org.meli.testcase.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.meli.testcase.dto.TestCaseDto;
import org.meli.testcase.exception.BadRequestException;
import org.meli.testcase.exception.NotFoundException;
import org.meli.testcase.model.TestCaseEntity;
import org.meli.testcase.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    private final ObjectMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDto> getAllTestCases() {
        List<TestCaseEntity> testCasesList = testCaseRepository.findAll();
        if (testCasesList.isEmpty()) {
            throw new NotFoundException("No se encontraron casos de prueba.");
        }
        return testCasesList.stream()
                .map(test -> mapper.convertValue(test, TestCaseDto.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseDto getTestCaseById(Long id) {
        TestCaseEntity testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró un caso de prueba con el id: " + id));
        return mapper.convertValue(testCase, TestCaseDto.class);
    }

    @Override
    @Transactional
    public TestCaseDto createTestCase(TestCaseDto testCaseDto) {
        TestCaseEntity testCase = mapper.convertValue(testCaseDto, TestCaseEntity.class);
        TestCaseEntity savedTestCase = testCaseRepository.save(testCase);
        return mapper.convertValue(savedTestCase, TestCaseDto.class);
    }

    @Override
    @Transactional
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto) {
        TestCaseEntity existingTestCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró un caso de prueba con el id: " + id));
        existingTestCase.setDescription(testCaseDto.getDescription());
        existingTestCase.setTested(testCaseDto.getTested());
        existingTestCase.setPassed(testCaseDto.getPassed());
        existingTestCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        existingTestCase.setLastUpdate(testCaseDto.getLastUpdate());
        TestCaseEntity updatedTestCase = testCaseRepository.save(existingTestCase);
        return mapper.convertValue(updatedTestCase, TestCaseDto.class);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        TestCaseEntity existingTestCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró un caso de prueba con el id: " + id));
        testCaseRepository.delete(existingTestCase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDto> getTestCasesFiltered(String lastUpdateString) {
        if (lastUpdateString == null || lastUpdateString.isBlank()) {
            return getAllTestCases();
        }
        LocalDate lastUpdate = parseDate(lastUpdateString, "dd/MM/yyyy");
        List<TestCaseEntity> testCasesList = testCaseRepository.findByLastUpdateAfter(lastUpdate);
        if (testCasesList.isEmpty()) {
            throw new NotFoundException("No se encontraron casos de prueba actualizados después de: " + lastUpdate);
        }
        return testCasesList.stream()
                .map(test -> mapper.convertValue(test, TestCaseDto.class))
                .toList();
    }

    public LocalDate parseDate(String date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Fecha incorrecta, debe tener el formato: " + format);
        }
    }
}
