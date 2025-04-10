package com.example.ejcovid19.DTO;

import com.example.ejcovid19.repository.HealthEntityDb;
import com.example.ejcovid19.service.Symptom;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class PacientDTO {
    @Getter
    private String fullName;
    @Getter
    private Integer age;
    @Getter
    private String symptomName;

    public PacientDTO(String fullName, Integer age, String symptomName) {
        this.fullName = fullName;
        this.age = age;
        this.symptomName = symptomName;
    }
}
