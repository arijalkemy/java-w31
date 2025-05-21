package com.example.jpa.util;

import com.example.jpa.model.TestCase;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TestCaseSpecification {
    public static Specification<TestCase> hasPassed(Boolean passed) {
        return (root, criteriaQuery, criteriaBuilder)
                -> passed == null ? null : criteriaBuilder.equal(root.get("passed"), passed);
    }

    public static Specification<TestCase> hasTested(Boolean tested) {
        return (root, query, criteriaBuilder)
                -> tested == null ? null : criteriaBuilder.equal(root.get("tested"), tested);
    }

    public static Specification<TestCase> hasLastUpdate(LocalDate lastUpdate) {
        return (root, query, criteriaBuilder)
                -> lastUpdate == null ? null : criteriaBuilder.equal(root.get("lastUpdate"), lastUpdate);
    }

    public static Specification<TestCase> hasNumberOfTries(Integer numberOfTries) {
        return (root, query, criteriaBuilder)
                -> numberOfTries == null ? null : criteriaBuilder.equal(root.get("numberOfTries"), numberOfTries);
    }
}
