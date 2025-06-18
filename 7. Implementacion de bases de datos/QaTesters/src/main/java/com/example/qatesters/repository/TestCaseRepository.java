package com.example.qatesters.repository;

import com.example.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
