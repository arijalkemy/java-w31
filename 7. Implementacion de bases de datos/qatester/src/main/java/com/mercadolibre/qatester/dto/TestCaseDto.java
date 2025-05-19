package com.mercadolibre.qatester.dto;

import com.mercadolibre.qatester.modal.Functionality;
import com.mercadolibre.qatester.modal.Tester;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

public class TestCaseDto {


    private Long id_case;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private LocalDate lastUpdate;
    private Functionality functionality;
    private Long testerId;
    private String testerName;

}
