package org.meli.practicaIntegradoraPooP1;



public class Persona {

    private String nombre;
    private int edad, peso, altura;
    private String dni;

    public Persona() {}

    public Persona(String nombre, int edad, int peso, int altura, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int calcularIMC() {
        int imc = (int)Math.round(peso/Math.pow(this.altura, 2));
        if (imc > 20){
            return -1;
        }
        else if (imc >= 20 && imc <= 25){
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        if(this.edad >= 18){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                ", dni='" + dni + '\'' +
                '}';
    }
}
