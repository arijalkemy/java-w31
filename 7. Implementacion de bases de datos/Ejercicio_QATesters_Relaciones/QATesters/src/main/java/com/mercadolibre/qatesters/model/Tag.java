package com.mercadolibre.qatesters.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private List<TestCase> testCases =  new ArrayList<>();
}
