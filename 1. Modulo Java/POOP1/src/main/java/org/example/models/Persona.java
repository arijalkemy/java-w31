package org.example.models;

public class Persona {
    String nombre;
    int edad;
    String dni;
    float peso;
    float altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        float calculoIMC= peso/(altura*altura);
        System.out.println("Índice de masa corporal (IMC): "+calculoIMC);

        if(calculoIMC<20){
            System.out.println("Bajo Peso.");
            return -1;
        }else if(calculoIMC>=20&&calculoIMC<=25){
            System.out.println("Peso Saludable.");
            return 1;
        }else{
            System.out.println("Sobrepeso.");
            return 1;
        }
    }

    public String toString(){
        return "Nombre: "+nombre+"\n"+"Edad: "+edad+" años.\n"+"DNI: "+dni+"\n"+
                "Peso: "+peso+" KG\n"+"Altura: "+altura+" m";
    }

    public boolean esMayorDeEdad(){
        if(edad>18){
            System.out.println("Persona es mayor de edad.");
          return true;
        }else{
            System.out.println("Persona es menor de edad.");
            return false;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
