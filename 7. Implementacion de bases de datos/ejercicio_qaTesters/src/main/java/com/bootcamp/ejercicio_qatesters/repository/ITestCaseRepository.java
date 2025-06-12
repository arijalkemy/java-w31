package com.bootcamp.ejercicio_qatesters.repository;

import com.bootcamp.ejercicio_qatesters.dto.TestCaseDto;
import com.bootcamp.ejercicio_qatesters.model.TestCase;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
  List<TestCaseDto> findByLastUpdate(LocalDate lastUpdate);
}
