package co.com.mercadolibre.practicaqatesters.service;

import co.com.mercadolibre.practicaqatesters.dto.TestCaseDto;
import co.com.mercadolibre.practicaqatesters.model.TestCase;
import co.com.mercadolibre.practicaqatesters.repository.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements ITestCaseService{

    private final TestCaseRepository repository;

    @Override
    public void save(TestCaseDto testCaseDto) {
        TestCase testCase = TestCase.builder()
                .id(testCaseDto.getId())
                .description(testCaseDto.getDescription())
                .tested(testCaseDto.isTested())
                .passed(testCaseDto.isPassed())
                .numberOfTries(testCaseDto.getNumberOfTries())
                .lastUpdate(testCaseDto.getLastUpdate())
                .build();
        repository.save(testCase);
    }

    @Override
    public void update(TestCaseDto testCaseDto, Long id) {
        TestCaseDto testCaseDtoFound = this.getById(id);
        TestCase testCase = TestCase.builder()
                .id(testCaseDtoFound.getId())
                .description(testCaseDtoFound.getDescription())
                .tested(testCaseDtoFound.isTested())
                .passed(testCaseDtoFound.isPassed())
                .numberOfTries(testCaseDtoFound.getNumberOfTries())
                .lastUpdate(testCaseDtoFound.getLastUpdate())
                .build();
        testCase
                .setDescription(testCaseDto.getDescription())
                        .setTested(testCaseDto.isTested())
                                .setPassed(testCaseDto.isPassed())
                                        .setNumberOfTries(testCaseDto.getNumberOfTries())
                                                .setLastUpdate(testCaseDto.getLastUpdate());
        repository.save(testCase);
    }

    @Override
    public List<TestCaseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(t -> TestCaseDto.builder()
                        .id(t.getId())
                        .description(t.getDescription())
                        .tested(t.isTested())
                        .passed(t.isPassed())
                        .numberOfTries(t.getNumberOfTries())
                        .lastUpdate(t.getLastUpdate())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public TestCaseDto getById(Long id) {
        TestCase testCaseFound = repository.findAll()
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("no encontrado"));

        return TestCaseDto.builder()
                .id(testCaseFound.getId())
                .description(testCaseFound.getDescription())
                .tested(testCaseFound.isTested())
                .passed(testCaseFound.isPassed())
                .numberOfTries(testCaseFound.getNumberOfTries())
                .lastUpdate(testCaseFound.getLastUpdate())
                .build();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TestCaseDto> getAllByLastUpdate(LocalDate localDate) {
        return this.getAll()
                .stream()
                .filter(t -> t.getLastUpdate().isEqual(localDate))
                .toList();
    }
}
