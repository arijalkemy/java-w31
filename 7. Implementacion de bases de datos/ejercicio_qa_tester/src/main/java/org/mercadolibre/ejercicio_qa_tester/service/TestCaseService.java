package org.mercadolibre.ejercicio_qa_tester.service;

import org.mercadolibre.ejercicio_qa_tester.entities.TestCase;

import java.util.List;

public interface TestCaseService {
    // POST - Create test cases
    String createTestCase(TestCase testCase);

    // GET - Get all and by ID
    List<TestCase> getAllTestCase();
    TestCase getTestCaseById(Long id);

    // PUT - Update test case
    String updateTestCase(Long id, TestCase testCase);

    // DELETE - Delete test case
    String deleteTestCase(Long id);
}
