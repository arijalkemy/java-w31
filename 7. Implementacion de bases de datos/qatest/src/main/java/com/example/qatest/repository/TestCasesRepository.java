package com.example.qatest.repository;

import com.example.qatest.model.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TestCasesRepository extends JpaRepository<TestCase, Long> {
    @Query("SELECT DISTINCT tc FROM TestCase tc JOIN tc.executionResults er WHERE er.executionTimestamp >= :timestamp")
    List<TestCase> findTestCasesWithExecutionAfter(@Param("timestamp") LocalDateTime timestamp);
}
