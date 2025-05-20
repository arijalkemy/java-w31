package co.com.mercadolibre.practicaqatesters.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Table(name = "test_case")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private boolean tested, passed;

    @Column(name = "number_of_tries")
    private int numberOfTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
