package co.com.mercadolibre.diecinueve.coviddiecinueve.domain;

import co.com.mercadolibre.diecinueve.coviddiecinueve.enums.Severity;

public class Symptom {

    private String code, name;
    private Severity severity;

    public Symptom() {
    }

    public Symptom(String code, String name, Severity severity) {
        this.code = code;
        this.name = name;
        this.severity = severity;
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

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    
}
