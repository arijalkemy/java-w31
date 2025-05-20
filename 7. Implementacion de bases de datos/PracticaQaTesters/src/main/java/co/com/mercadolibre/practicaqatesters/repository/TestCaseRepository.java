package co.com.mercadolibre.practicaqatesters.repository;

import co.com.mercadolibre.practicaqatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
