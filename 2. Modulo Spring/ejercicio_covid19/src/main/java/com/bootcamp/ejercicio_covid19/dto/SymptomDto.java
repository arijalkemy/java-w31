package com.bootcamp.ejercicio_covid19.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SymptomDto implements Serializable {
    private String code;
    private String name;
    private String severityLevel;

    public SymptomDto(String code, String name, String severityLevel) {
        this.code = code;
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }
}
