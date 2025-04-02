package dev.michell;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;


    public Persona() {
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularImc(){
        double imc =  peso / (altura * altura);

        if (imc < 20) {
            return - 1;
        }else if (imc >= 20 && imc <= 25) {
            return 0;
        }else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }


    @Override
    public String toString() {
        return "===================================\n" +
                "    Informacion de la Persona   \n" +
                "===================================\n" +
                "Nombre: " + nombre + "\n" +
                "Edad: " + edad + " años\n" +
                "DNI: " + dni + "\n" +
                "Peso: " + peso + " kg\n" +
                "Altura: " + altura + " m\n";
    }

    public String getNombre() {
        return nombre;
    }
}
