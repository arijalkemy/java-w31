package P1.Ejercicio2;

/**
 * Ejercicio 2
 * Vamos a crear diferentes constructores en la clase Persona,
 * uno sin parámetros, el segundo debe recibir como parámetro
 * nombre, edad y dni; por último creamos un tercero que reciba
 * todos los atributos de la clase como parámetros.
 */ 
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