package com.mercadolibre.testersbd.repository;

import com.mercadolibre.testersbd.dto.TestCaseDto;
import com.mercadolibre.testersbd.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findByLastUpdateAfter(LocalDate lastUpdate);
}
