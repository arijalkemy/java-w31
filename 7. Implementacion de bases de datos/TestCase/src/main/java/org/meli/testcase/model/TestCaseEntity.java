package org.meli.testcase.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "testCase")
public class TestCaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idCase;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Boolean tested;
    @Column(nullable = false)
    private Boolean passed;
    @Column(nullable = false)
    private Integer numberOfTries;
    @Column(nullable = false)
    private LocalDate lastUpdate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tester_id", nullable = false)
    private TesterEntity tester;
}
