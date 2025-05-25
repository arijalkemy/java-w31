package com.mercadolibre.testersbd.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "testers")
public class Tester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;


    //Uno a uno
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "test_case_id", referencedColumnName = "id")
//    private TestCase testCase;

    //Uno a muchos
//    @OneToMany(mappedBy = "tester", cascade = CascadeType.ALL)
//    private Set<TestCase> testCases;


    //Muchos a Muchos

//    @ManyToMany
//    @JoinTable(
//            name = "testers_test_cases",
//            joinColumns = @JoinColumn(name = "tester_id"),
//            inverseJoinColumns = @JoinColumn(name = "test_case_id")
//    )
//    private Set<TestCase> testCases;
}
