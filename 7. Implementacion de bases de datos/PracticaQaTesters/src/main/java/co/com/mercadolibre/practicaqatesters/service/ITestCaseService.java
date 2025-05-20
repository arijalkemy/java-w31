package co.com.mercadolibre.practicaqatesters.service;

import co.com.mercadolibre.practicaqatesters.dto.TestCaseDto;
import co.com.mercadolibre.practicaqatesters.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    void save(TestCaseDto testCaseDto);
    void update (TestCaseDto testCaseDto, Long id);
    List<TestCaseDto> getAll();
    TestCaseDto getById(Long id);
    void deleteById(Long id);
    List<TestCaseDto> getAllByLastUpdate(LocalDate localDate);

}
