package com.qa_tester.ejercicio_qa.repository;

import com.qa_tester.ejercicio_qa.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
