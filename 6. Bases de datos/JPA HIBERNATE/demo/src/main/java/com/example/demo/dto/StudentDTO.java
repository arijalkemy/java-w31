package com.example.demo.dto;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String dni;
    private String firstName;
    private String lastName;

    public StudentDTO(Long id, String dni, String firstName, String lastName) {
        this.id = id;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
