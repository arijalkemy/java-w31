public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jose", 25, "42876543");
        Persona persona3 = new Persona("Juan", 45, "35679843", 80.5, 182.3);
        // Persona persona4 = new Persona("Mariano", 34);

        System.out.println("El rango de imc es: " + persona3.calcularIMC());
        System.out.println(persona3.esMayorDeEdad() ? "Es mayor de edad" : "Es menor de edad");
        System.out.println(persona3.toString());
    }
}