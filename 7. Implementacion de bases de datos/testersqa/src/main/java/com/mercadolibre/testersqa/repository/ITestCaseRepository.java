package com.mercadolibre.testersqa.repository;

import com.mercadolibre.testersqa.dto.TestCaseDto;
import com.mercadolibre.testersqa.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
