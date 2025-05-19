package com.bootcamp.qatesters.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.qatesters.model.TestCase;

public interface ITestCaseRepository extends JpaRepository <TestCase, Long> {
     List<TestCase> findByLastUpdateAfter(Date lastUpdate);
}
