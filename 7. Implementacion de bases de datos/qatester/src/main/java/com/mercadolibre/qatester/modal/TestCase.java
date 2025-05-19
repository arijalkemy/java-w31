package com.mercadolibre.qatester.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "testCase")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean tested;

    @Column(nullable = false)
    private Boolean passed;

    @Column(name = "number_of_tries", nullable = false)
    private int number_of_tries;

    @Column(name = "last_update", nullable = false)
    private LocalDate lastUpdate;

    @OneToOne(mappedBy = "testCase",fetch = FetchType.LAZY)
    private Functionality functionality;

    @ManyToOne
    @JoinColumn(name = "tester_id",nullable = false)
    private Tester tester;

    @ManyToMany(mappedBy = "testCases")
    private Set<Project> projects;

}
