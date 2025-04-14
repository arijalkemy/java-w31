package com.mercadoLibre;

public class Persona {
    private String nombre;
    private int edad;

    private String dni;
    private double peso;
    private double altura;

    public Persona() { }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

   public int calcularIMC() {
        double imc = peso / Math.pow(altura, 2);
        return imc < 20 ? -1 : imc <= 25 ? 0 : 1;
   }

   public String esMayorDeEdad() {
        return edad > 18 ? " es mayor de edad." : " es menor de edad.";
   }

    public void imprimirInfoPeso() {
        String estadoIMC = switch (calcularIMC()) {
            case -1 -> "bajo";
            case 0 -> "saludable";
            case 1 -> "alto";
            default -> "desconocido";
        };
        System.out.println("El nivel de peso de " + nombre + " es " + estadoIMC + ".");
    }

   public void imprimirInfoPersona() {
        System.out.println("Nombre: " + nombre +
                            "\nEdad: " + edad +
                            "\nDNI: " + dni +
                            "\nPeso: " + peso + "kg" +
                            "\nAltura: " + altura + "m"
        );
   }


    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

}
