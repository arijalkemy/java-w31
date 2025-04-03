/*
* Vamos a crear diferentes constructores en la clase Persona, uno sin parámetros, 
* el segundo debe recibir como parámetro nombre, edad y dni; por último creamos un tercero que reciba todos los 
* atributos de la clase como parámetro.
 */

public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    int alturaEnCm;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, int alturaEnCm) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.alturaEnCm = alturaEnCm;
    }
}
