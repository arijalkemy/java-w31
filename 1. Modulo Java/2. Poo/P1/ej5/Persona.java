/*
En la clase Persona implementaremos los siguientes métodos:

- calcularIMC(): la fórmula para calcularlo es: peso / (altura^2) 
  (peso expresado en kg y altura en mts).  
  - Si este cálculo devuelve un valor menor que 20, la función debe retornar -1.  
  - Si devuelve un número entre 20 y 25 inclusive, el método debe retornar 0.  
  - Si devuelve un número mayor que 25, debe retornar 1.  

- Una vez creado el método anterior, agreguemos el método esMayorDeEdad(), 
  el cual debe retornar un valor booleano, teniendo en cuenta que la mayoría de edad 
  será considerada en este caso, a partir de los 18 años.  

- Finalmente, agregar un método toString() que va a devolver toda la información de la persona.  

¡Recuerda! Puedes ayudarte de los métodos de la clase java.lang.Math para calcular la potencia.
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
        double imc = this.peso / (alturaEnMts * alturaEnMts);
        System.out.println("IMC: " + imc);

        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
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
                + "Peso: " + this.peso + "\n"
                + "Altura en cm: " + this.alturaEnCm;
    }

    public static void main(String[] args) {
        // Creación de objetos de tipo Persona
        Persona personaDefault = new Persona();
        Persona personaParcial = new Persona("Juan", 25, "12345678");
        Persona personaCompleta = new Persona("Ana", 30, "87654321", 70.0, 170);

        // Imprimir los detalles de cada objeto
        System.out.println("Persona Default: " + personaDefault);
        System.out.println("Persona Parcial: " + personaParcial);
        System.out.println("Persona Completa: " + personaCompleta);

        // Calcular IMC
        System.out.println("IMC de " + personaCompleta.nombre + ": " + personaCompleta.calcularIMC());
        // Verificar si es mayor de edad
        System.out.println(personaCompleta.nombre + " es mayor de edad: " + personaCompleta.esMayorDeEdad());
    }
}
