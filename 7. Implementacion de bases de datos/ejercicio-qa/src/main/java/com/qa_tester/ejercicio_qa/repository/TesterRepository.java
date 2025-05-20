package com.qa_tester.ejercicio_qa.repository;

import com.qa_tester.ejercicio_qa.model.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TesterRepository extends JpaRepository<Tester, Long> {
    boolean existsByNameAndSeniority(String name, String seniority);
}
