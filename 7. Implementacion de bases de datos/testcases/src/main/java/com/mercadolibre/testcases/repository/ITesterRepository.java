package com.mercadolibre.testcases.repository;

import com.mercadolibre.testcases.model.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITesterRepository extends JpaRepository<Tester, Long> {
}
