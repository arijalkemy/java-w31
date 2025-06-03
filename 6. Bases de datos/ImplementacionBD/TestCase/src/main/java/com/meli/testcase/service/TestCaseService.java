package com.meli.testcase.service;

import com.meli.testcase.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseService {
    public TestCase createTestCase(TestCase testCase);
    public List<TestCase> getAllTestCase();
    public TestCase getTestCaseById(long id);
    public String updateTestCase(Long id, TestCase testCase);
    public void deleteTestCase(Long id);
}
