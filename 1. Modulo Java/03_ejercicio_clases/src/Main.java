package src;

public class Main {
    public static void main(String[] args) {
        Persona personauno = new Persona();
        Persona personaJorge = new Persona("Jorge", 20, "38499499");
        Persona personaFull = new Persona("Pepe", 49, "1", 2399, 3.49 );

        int resultado = personaFull.calcularImc();
        boolean esMayor = personaJorge.esMayor();
        System.out.println(resultado == -1 ? "Es bajo peso" : resultado == 0 ? "Peso saludable" : "Sobrepeso." );
        System.out.println(esMayor ? "Es mayor de edad." : "Es menor de edad");
        System.out.println(personaFull.toString());
    }
}
