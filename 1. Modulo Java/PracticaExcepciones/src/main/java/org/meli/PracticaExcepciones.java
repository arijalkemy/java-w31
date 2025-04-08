package org.meli;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void calcularCociente() throws Exception {
        try {
            int cociente = b / a;
            System.out.println("El cociente de " + a + " y " + b + " es: " + cociente);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}