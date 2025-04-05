// Ejercicio 3 clase main
public class Main {
    public static void main(String[] args) {
        // Ejercicio 4
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Martin", 23, "44556677");
        Persona persona3 = new Persona("Juan", 32, "44556677", 70, 1.78);
        /*
        Persona persona4 = new Persona("Martin", 23);
        Esta declaracion lanza un error ya que no es posible crear una persona solo con
        nombre y edad por que no tenemos un constructor declarado que cumpla
        con esos parametros.
         */

        switch (persona3.calcularMC()) {
            case -1 -> System.out.println("Indice IMC: Bajo Peso");
            case 0 -> System.out.println("Indice IMC: Peso Saludable");
            case 1 -> System.out.println("Indice IMC: Sobrepeso");
        }

        if (persona3.esMayorDeEdad()) System.out.println("Sos mayor de edad!");
        else System.out.println("Sos menor de edad!");

        System.out.println(persona3.toString());

    }
}
