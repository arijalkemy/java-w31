/*
Desde la clase Main vamos a calcular el IMC de la última persona que creamos 
(la que creamos correctamente mediante el constructor que recibe todos los atributos como parámetro). 

También vamos a averiguar si es mayor de edad o no; ten en cuenta que en ambos casos, 
dependiendo de los resultados retornados por los métodos, debes imprimir un mensaje acorde para el usuario. 

Finalmente, queremos mostrar todos los datos de esa persona imprimiendo dicha información por consola. 

El formato en que vas a mostrar los datos y los mensajes quedan a tu criterio, 
pero debe ser legible y descriptivo para quien ve la salida del programa. 


Referencias:

Índice de masa corporal (IMC)      Nivel de peso
-----------------------------------------------
Por debajo de 20                    Bajo peso
Entre 20 y 25 inclusive             Peso saludable
Mayor de 25                         Sobrepeso
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

    public int calcularIMC() {
        double alturaEnMts = this.alturaEnCm / 100.0;
        double imc = this.peso / Math.pow(alturaEnMts, 2);

        System.out.printf("IMC de %s: %.2f%n", this.nombre, imc);

        if (imc < 20) {
            System.out.println("Nivel de peso: Bajo peso");
            return -1;
        } else if (imc <= 25) {
            System.out.println("Nivel de peso: Peso saludable");
            return 0;
        } else {
            System.out.println("Nivel de peso: Sobrepeso");
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n"
                + "Edad: " + this.edad + "\n"
                + "DNI: " + this.dni + "\n"
                + "Peso: " + this.peso + " kg\n"
                + "Altura: " + this.alturaEnCm + " cm";
    }

    public static void main(String[] args) {
        // Creación de objetos de tipo Persona
        Persona personaDefault = new Persona();
        Persona personaParcial = new Persona("Juan", 25, "12345678");
        Persona personaCompleta = new Persona("Ana", 30, "87654321", 70.0, 170);

        // Mostrar información de cada objeto
        System.out.println("Información de Persona Default:\n" + personaDefault + "\n");
        System.out.println("Información de Persona Parcial:\n" + personaParcial + "\n");
        System.out.println("Información de Persona Completa:\n" + personaCompleta + "\n");

        // Calcular IMC de la última persona creada
        int resultadoIMC = personaCompleta.calcularIMC();

        // Verificar si es mayor de edad
        if (personaCompleta.esMayorDeEdad()) {
            System.out.println(personaCompleta.nombre + " es mayor de edad.\n");
        } else {
            System.out.println(personaCompleta.nombre + " es menor de edad.\n");
        }
    }
}
