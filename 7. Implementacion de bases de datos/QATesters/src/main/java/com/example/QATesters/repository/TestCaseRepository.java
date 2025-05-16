package com.example.QATesters.repository;

import com.example.QATesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase,Long> {
    List<TestCase> findByLastUpdateAfter(LocalDate date);
}
