package com.example.jpa.dto;

import com.example.jpa.service.ITestCaseService;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestCaseDto implements Serializable {

    private Long id;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description can have up to 255 characters")
    private String description;

    @NotNull(message = "Tested flag is required")
    private Boolean tested;

    @NotNull(message = "Passed flag is required")
    private Boolean passed;

    @NotNull(message = "Number Of Tries is required")
    @Min(value = 0, message = "Number of tries must be zero or positive")
    private Integer numberOfTries;

    private LocalDate lastUpdate;
}
