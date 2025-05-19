package com.meli.maolaya.crudjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meli.maolaya.crudjpa.model.TestCase;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

}
