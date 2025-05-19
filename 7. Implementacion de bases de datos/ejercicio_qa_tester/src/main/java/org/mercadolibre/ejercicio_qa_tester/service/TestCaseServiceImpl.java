package org.mercadolibre.ejercicio_qa_tester.service;

import org.mercadolibre.ejercicio_qa_tester.entities.TestCase;
import org.mercadolibre.ejercicio_qa_tester.exceptions.NotFoundException;
import org.mercadolibre.ejercicio_qa_tester.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseServiceImpl implements TestCaseService{

    private final TestCaseRepository repository;

    public TestCaseServiceImpl(TestCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public String createTestCase(TestCase testCase) {

        repository.save(testCase);

        return "Se creó el caso de prueba correctamente.";
    }

    @Override
    public List<TestCase> getAllTestCase() {
        return repository.findAll();
    }

    @Override
    public TestCase getTestCaseById(Long id) {

        TestCase testCase = repository.findById(id).orElse(null);

        if(testCase == null) {
            throw new NotFoundException("No se encontró el caso de uso deseado");
        }

        return testCase;
    }

    @Override
    public String updateTestCase(Long id, TestCase testCase) {

        TestCase found = repository.findById(id).orElse(null);

        if(found == null) {
            throw new NotFoundException("No se encontró el caso de uso deseado");
        }

        found.setDescription(testCase.getDescription());
        found.setTested(testCase.getTested());
        found.setPassed(testCase.getPassed());
        found.setNumberOftries(found.getNumberOftries() + 1);

        repository.save(found);
        return "Se actualizó correctamente el caso de prueba " + id;
    }

    @Override
    public String deleteTestCase(Long id) {

        repository.deleteById(id);

        return "Se eliminó el caso de prueba " + id;
    }
}
