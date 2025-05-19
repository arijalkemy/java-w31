package org.mercadolibre.ejercicio_qa_tester.repository;

import org.mercadolibre.ejercicio_qa_tester.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
