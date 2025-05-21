package com.example.jpa.repository;

import com.example.jpa.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> , JpaSpecificationExecutor<TestCase> {
}
