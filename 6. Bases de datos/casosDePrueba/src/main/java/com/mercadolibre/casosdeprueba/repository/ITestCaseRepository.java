package com.mercadolibre.casosdeprueba.repository;

import com.mercadolibre.casosdeprueba.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
