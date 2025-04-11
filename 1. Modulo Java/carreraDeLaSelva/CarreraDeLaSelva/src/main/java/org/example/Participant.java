package org.example;

import java.util.Objects;

public class Participant {
    private String dni;
    private String name;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    private String emergencyContact;
    private String rh;
    private boolean registerParticipant;

    public Participant() {
    }

    public Participant(String dni, String name, String lastName, int age, String phoneNumber, String emergencyContact, String rh) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emergencyContact = emergencyContact;
        this.rh = rh;
        this.registerParticipant = false;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public boolean isRegisterParticipant() {
        return registerParticipant;
    }

    public void setRegisterParticipant(boolean registerParticipant) {
        this.registerParticipant = registerParticipant;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(dni, that.dni) && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(age, that.age) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(emergencyContact, that.emergencyContact) && Objects.equals(rh, that.rh);
    }

    @Override
    public String toString() {
        return "Participant: {" +
                "dni='" + dni + '\'' +
                ", name='" + name + " " + lastName +'\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", rh='" + rh + '\'' +
                '}';
    }

}
