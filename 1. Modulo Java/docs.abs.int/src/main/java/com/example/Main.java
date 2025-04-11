
package com.example;


public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan", "Pérez", new String[]{"Java", "Python", "C++"});
        librosPDF l1 = new librosPDF("El Principito", "Antoine de Saint-Exupéry", 1943, "978-3-16-148410-0" );
        reporte r1 = new reporte("Reporte de Ventas del mes de Agosto. En dicho mes...", 10, "Juan Perez", "Maria Lopez");
        Curriculum c1 = new Curriculum(p1);

        Impresora.imprimirDocumento(c1);
        Impresora.imprimirDocumento(l1);
        Impresora.imprimirDocumento(r1);

    }
}