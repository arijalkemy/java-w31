package com.mercadolibre.testcases.repository;

import com.mercadolibre.testcases.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findAllByPassed(Boolean passed);
    List<TestCase> findAllByTested(Boolean tested);
    List<TestCase> findAllByLastUpdateIsAfter(LocalDate lastUpdate);
}
