package com.mercadolibre.testcase.repository;

import com.mercadolibre.testcase.models.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findByLastUpdateGreaterThanEqual(LocalDate lastUpdate);

}
