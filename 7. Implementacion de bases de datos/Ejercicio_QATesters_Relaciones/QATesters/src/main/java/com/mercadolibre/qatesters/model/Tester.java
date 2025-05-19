package com.mercadolibre.qatesters.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tester {

    @Id
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "tester", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TestCase> testCases =  new ArrayList<>();;
}
