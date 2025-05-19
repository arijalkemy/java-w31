package com.mercadolibre.qatesters.model;

import com.mercadolibre.qatesters.dto.TestCaseDto;
import jakarta.persistence.*;

@Entity
public class BugReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String summary;
    private String status;

    @OneToOne(mappedBy = "bugReport")
    private TestCase testCase;


}
