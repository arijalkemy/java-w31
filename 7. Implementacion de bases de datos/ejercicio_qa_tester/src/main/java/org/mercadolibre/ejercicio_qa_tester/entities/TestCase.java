package org.mercadolibre.ejercicio_qa_tester.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter @Setter
@Entity
@Table (name = "test_case")
@AllArgsConstructor @NoArgsConstructor
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;

    @Column(name = "description")
    private String description;

    @Column(name = "tested")
    private Boolean tested = Boolean.TRUE;

    @Column(name = "passed")
    private Boolean passed = Boolean.TRUE;

    @Column(name = "number_of_tries")
    private int numberOftries = 1;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

    @PrePersist
    protected void onCreate() {
        lastUpdate = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdate = LocalDate.now();
    }
}
