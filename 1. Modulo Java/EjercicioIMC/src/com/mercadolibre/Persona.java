package com.mercadolibre;

public class Persona {
    String nombre;
    String dni;
    int edad;
    double peso;
    double altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        int resultado = 0;
        double calculo = 0;
        calculo = this.peso / (Math.pow(this.altura, 2));
        if(calculo < 20){
            resultado = -1;
        } else if (calculo >= 20 && calculo <= 25){
            resultado = 0;
        } else {
            resultado = 1;
        }
        return resultado;
    }

    public boolean esMayorDeEdad(){
        if(this.edad >= 18){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String estadoIMC;

        switch (calcularIMC()) {
            case -1:
                estadoIMC = "Bajo peso";
                break;
            case 0:
                estadoIMC = "Peso normal";
                break;
            case 1:
                estadoIMC = "Sobrepeso";
                break;
            default:
                estadoIMC = "Estado desconocido";
        }

        String esMayorDeEdad = this.esMayorDeEdad() ? "es mayor de edad" : "es menor de edad";
        return "La persona es: " +
                nombre + ", " +
                "dni: " + dni + ", " +
                "edad: " + edad + ", " +
                "peso: " + peso + ", " +
                "altura: " + altura + ", " +
                "su IMC es: " + estadoIMC + ", " +
                esMayorDeEdad;
    }
}
