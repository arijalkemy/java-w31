package com.company;

import java.time.LocalDate;
import java.util.Date;

public class User {
    private String id, firstName, lassName, gender,pais;
    private LocalDate birthDate;

    public User(String id, String firstName, String lassName, String gender, LocalDate birthDate,String pais) {
        this.id = id;
        this.firstName = firstName;
        this.lassName = lassName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.pais = pais;

    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLassName() {
        return lassName;
    }

    public void setLassName(String lassName) {
        this.lassName = lassName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lassName='" + lassName + '\'' +
                ", gender='" + gender + '\'' +
                ", pais='" + pais + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
