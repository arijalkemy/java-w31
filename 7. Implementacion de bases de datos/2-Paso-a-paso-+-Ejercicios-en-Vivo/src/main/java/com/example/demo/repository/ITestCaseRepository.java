package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TestCase;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
