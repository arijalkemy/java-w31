package com.example.qatest.repository;

import com.example.qatest.model.entity.TestExecutionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestExecutionResultRepository extends JpaRepository<TestExecutionResult, Long> {
}
