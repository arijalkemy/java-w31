public class Main {

    // Ejercicio 3
    public static void main(String[] args) {

        // Ejercicio 4
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Marta", 7, "56784993");
        Persona persona3 = new Persona("Juan", 48, "19467782", 89.2F, 184);

        // Ejercicio 6
        System.out.println("IMC = " + persona3.calcularIMC());
        System.out.println("Mayor de edad = " + persona3.esMayorDeEdad());
        System.out.println(persona3.toString());
    }
}