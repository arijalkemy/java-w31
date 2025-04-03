package P1.Ejercicio3y4;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = -1;
        this.dni = "Sin dni";
        this.peso = -1;
        this.altura = -1;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = -1;
        this.altura = -1;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
}