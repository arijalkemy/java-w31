package co.com.mercadolibre.practicaqatesters.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestCaseDto {

    private Long id;

    private String description;

    private boolean tested, passed;

    @JsonProperty("number_of_tries")
    private int numberOfTries;

    @JsonProperty("last_update")
    private LocalDate lastUpdate;
}
