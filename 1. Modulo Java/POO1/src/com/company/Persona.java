package com.company;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int calcularIMC(){
        double IMC = peso / (altura * altura);

        if( IMC < 20){
            return -1;
        }else if(IMC>=20 && IMC<=25){
            return 0;
        }else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if(edad>18){
            System.out.println(nombre + " es mayor de edad.");
            return true;
        }
        System.out.println(nombre + " es menor de edad.");
        return false;
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
