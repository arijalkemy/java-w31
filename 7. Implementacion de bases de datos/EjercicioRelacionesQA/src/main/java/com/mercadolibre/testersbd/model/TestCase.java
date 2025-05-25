package com.mercadolibre.testersbd.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "test_cases")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Boolean tested;
    private Boolean passed;

    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonProperty("last_update")
    private LocalDate lastUpdate;

    //uno a uno
//    @OneToOne(mappedBy = "testCase")
//    private Tester tester;

    //Uno a muchos
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tester_id", nullable = false)
//    private Tester tester;


    //muchos a muchos
//    @ManyToMany(mappedBy = "testCases")
//    private Set<Tester> testers;

}
