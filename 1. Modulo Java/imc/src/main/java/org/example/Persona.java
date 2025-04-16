package org.example;

public class Persona {
    String nombre;
    Integer edad;
    String dni;
    Double peso;
    Double altura;

    public Persona() {}
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

    public void setAltura(Double altura) {
        this.altura = altura;
    }
    public Double getAltura() {
        return altura;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Integer getEdad() {
        return edad;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public Double getPeso() {
        return peso;
    }

    public Integer calcularIMC(){
        Double imc = peso/ Math.pow(altura, 2);

        if (imc < 20)
            return -1;
        else if (imc >= 20 && imc <= 25)
            return 0;
        else
            return 1;
    }

    public Boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        Integer imc = calcularIMC();
        String nivelDePeso = imc == -1 ? "Bajo de peso"
                            : imc == 0 ? "Peso Saludale"
                            : "SobrePeso";
        return "{" +
                    "nombre: " + nombre + ", " +
                    "edad:" + edad + ", " +
                    "dni: " + dni + ", " +
                    "altura: " + altura + ", " +
                    "peso: " + peso + ", " +
                    "imc: " + nivelDePeso + ", " +
                    "mayorDeEdad: " + esMayorDeEdad() +
                "}";
    }
}
