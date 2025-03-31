package org.example.ejercicio1OOP;

public class Persona {
    private static final int MAYORIA_DE_EDAD = 18;
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private float peso;
    private float alturaEnMts;

    public Persona() {
        this("", "", 0, "", 0.0F, 0.0F);
    }

    public Persona(String nombre, String apellido, int edad, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.peso = 0.0F;
        this.alturaEnMts = 0.0F;
    }

    public Persona(String nombre, String apellido, int edad, String dni, float peso, float alturaEnMts) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.alturaEnMts = alturaEnMts;
    }

    public int calcularIMC() {
        if(this.alturaEnMts == 0.0F) {
            throw new ArithmeticException("No se puede dividir por 0");
        }

        float imc = peso / (alturaEnMts * alturaEnMts);

        if (imc < 20.0) {
            return -1;
        } else if (imc >= 20.0 && imc <= 25.0) {
            return 0;
        }

        return 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= MAYORIA_DE_EDAD;
    }

    @Override
    public String toString() {
        return "Persona{" +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", alturaEnMts=" + alturaEnMts +
                '}';
    }
}
