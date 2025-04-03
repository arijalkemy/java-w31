
/*
En la clase Main que acabamos de crear, dentro del método main() te pedimos que crees 
un objeto de tipo Persona por cada constructor que hayamos definido en la clase, 
recuerda poner un nombre significativo a las variables donde vas a asignar cada objeto. 

¿Cómo lo harías? 

A continuación vamos a crear otro objeto de tipo Persona y vamos a construirlo pasando 
solamente un valor para el nombre y otro para la edad en el constructor. 

¿Es esto posible? 

¿Qué sucede si tratamos de hacer esto?
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
        // Creación de objetos de tipo Persona
        Persona personaDefault = new Persona();
        Persona personaParcial = new Persona("Juan", 25, "12345678");
        Persona personaCompleta = new Persona("Ana", 30, "87654321", 70.0, 170);

        // Imprimir los detalles de cada objeto
        System.out.println("Persona Default: " + personaDefault.nombre + ", Edad: " + personaDefault.edad + ", DNI: " + personaDefault.dni);
        System.out.println("Persona Parcial: " + personaParcial.nombre + ", Edad: " + personaParcial.edad + ", DNI: " + personaParcial.dni);
        System.out.println("Persona Completa: " + personaCompleta.nombre + ", Edad: " + personaCompleta.edad + ", DNI: " + personaCompleta.dni + ", Peso: " + personaCompleta.peso + ", Altura: " + personaCompleta.alturaEnCm);

    }
}
