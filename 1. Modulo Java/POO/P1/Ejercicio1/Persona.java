package P1.Ejercicio1;

/*
 * Ejercicio 1
 * Creá una clase Persona, la cual tendrá los siguientes atributos:
 * nombre, edad, dni (en este caso vamos a representarlo como una
 * cadena de caracteres), peso y altura ¿Qué tipo de dato le asignarías
 * a las variables de instancia? ¿Cómo sería la estructura básica de tu
 * clase?
 */
public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;
    
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
}
