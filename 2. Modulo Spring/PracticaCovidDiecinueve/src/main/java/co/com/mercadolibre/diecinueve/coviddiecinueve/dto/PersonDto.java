package co.com.mercadolibre.diecinueve.coviddiecinueve.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PersonDto {

    private Long id;
    private String name, lastName;
    private int age;
    private SymptomDto symptomDto;
    
    public PersonDto() {
    }

    public PersonDto(Long id, String name, String lastName, int age, SymptomDto symptomDto) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.symptomDto = symptomDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SymptomDto getSymptomDto() {
        return symptomDto;
    }

    public void setSymptomDto(SymptomDto symptomDto) {
        this.symptomDto = symptomDto;
    }
}
