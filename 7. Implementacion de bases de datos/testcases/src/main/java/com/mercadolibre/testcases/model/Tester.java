package com.mercadolibre.testcases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "tester")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "tester", cascade = CascadeType.ALL)
    private List<TestCase> testCases;
}
