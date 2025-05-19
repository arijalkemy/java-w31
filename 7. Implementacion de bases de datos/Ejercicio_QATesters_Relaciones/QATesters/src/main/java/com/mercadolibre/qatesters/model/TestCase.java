package com.mercadolibre.qatesters.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Boolean tested;

    private Boolean passed;

    private Integer numberOfTries;

    private LocalDate lastUpdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bugReport_id", referencedColumnName = "id")
    private BugReport bugReport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tester_id")
    private Tester tester;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "testCase_tag",
            joinColumns = @JoinColumn(name = "testCase_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")

    )
    private List<Tag> tags = new ArrayList<>();
}
