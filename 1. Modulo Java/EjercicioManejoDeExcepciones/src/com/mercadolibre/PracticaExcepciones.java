package com.mercadolibre;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void calcularCociente() throws Exception{
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (IllegalArgumentException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
