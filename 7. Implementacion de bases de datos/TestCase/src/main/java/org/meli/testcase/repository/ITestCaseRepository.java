package org.meli.testcase.repository;

import org.meli.testcase.model.TestCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCaseEntity, Long> {
    List<TestCaseEntity> findByLastUpdateAfter(LocalDate lastUpdate);
}
