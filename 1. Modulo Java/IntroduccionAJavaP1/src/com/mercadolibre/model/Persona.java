package com.mercadolibre.model;
import java.math.*;

public class Persona {
    private String nombre;
    private Integer edad;
    private String dni;
    private Double peso;
    private Double altura;

    public Persona() {
    }

    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, Double peso, Double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Integer calcularIMC(){
        double imc = peso / (Math.pow(altura, 2));
        return imc < 20 ? -1: imc <= 25? 0 : 1;
    }

    public Boolean esMayorDeEdad() {
        return this.edad >= 18;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
