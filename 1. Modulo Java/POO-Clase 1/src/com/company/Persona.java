package com.company;

public class Persona {
    private String nombre, dni;
    private Integer edad;
    private Double peso, altura;

    public Persona(){}
    public Persona (String nombre, Integer edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, Integer edad, String dni, Double peso, Double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    public Integer calcularIMC(){
        Double resultadoIMC = this.peso/(Math.pow(this.altura,2));
        if(resultadoIMC < 20){
            return -1;
        }else if(resultadoIMC >20 && resultadoIMC <26){
            return 0;
        }else{
            return 1;
        }
    }
    public Boolean esMayorDeEdad(){
        if(this.edad>= 18){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
