package org.example.P2OOP;

public class Ejercicio1 {

    public static void main(String[] args) {
        PracticaExcepciones p = new PracticaExcepciones();

        try {
            double v = p.divisionThatThrows();
            System.out.println(v);
        } catch (Exception e) {
            System.out.println("Se ha producido un error " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

    }

}
