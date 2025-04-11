package com.example;
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double altura;
    private double peso;
//1
    public Persona (){}
//2
    public Persona (String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
//3
    }

    @Override
    public String toString() {
        return  "Nombre: "+nombre+"\n"+"Edad: "+edad+" años.\n"+" DNI: "+dni+"\n"+
        "Peso: "+peso+" KG\n"+"Altura: "+altura+" m";
    }
    
    
    public Persona (String nombre, int edad, String dni, double altura, double peso){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public int calcularMC(){
        // Método para calcular el índice de masa corporal (IMC)
        // Fórmula: IMC = peso / (altura * altura)
        int imc = 0;
        imc = (int) (peso / (altura * altura));
       
        if (imc <20){
            System.out.println("Bajo Peso");
            return -1;
        }else if (imc >= 20 && imc <= 25){
            System.out.println("Saludable");
            return 0;
        }else {
            System.out.println("Obesidad");
            return 1;
    }
}
    public boolean esMayorDeEdad(){
        // Método para verificar si la persona es mayor de edad
        return edad >= 18;
    }
}
