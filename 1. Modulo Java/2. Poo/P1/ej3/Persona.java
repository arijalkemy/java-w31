/*
* Creá una clase nueva llamada Main, donde declares un método main como te enseñamos anteriormente. 
* Esto nos permitirá ejecutar nuestra aplicación.
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

    public static void main(String[] args) {

    }
}
