package org.example;

import java.util.*;

public class Main {
    private static List<Inscripcion> inscripciones = new ArrayList<>();
    private static int contadorInscripciones = 1;

    public static void main(String[] args) {
        Categoria chico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.");
        Categoria medio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria avanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Participante p1 = new Participante(1, "12345678", "Juan", "Pérez", 17, "1111", "2222", "O+");
        Participante p2 = new Participante(2, "23456789", "Ana", "García", 22, "3333", "4444", "A+");
        Participante p3 = new Participante(3, "34567890", "Luis", "López", 30, "5555", "6666", "B-");

        inscribirParticipante(p1, chico);
        inscribirParticipante(p2, medio);
        inscribirParticipante(p3, avanzado);

        System.out.println("\nInscriptos en Circuito medio:");
        mostrarInscriptosPorCategoria(medio);

        System.out.println("\nDesinscribiendo a Ana García...");
        desinscribirParticipante("23456789");

        System.out.println("\nInscriptos en Circuito medio:");
        mostrarInscriptosPorCategoria(medio);

        calcularRecaudacion(chico, medio, avanzado);
    }

    public static void inscribirParticipante(Participante p, Categoria c) {
        if (c.getNombre().toLowerCase().contains("avanzado") && p.getEdad() < 18) {
            System.out.println("No se permite inscribir menores de edad al circuito avanzado.");
            return;
        }
        Inscripcion inscripcion = new Inscripcion(contadorInscripciones++, c, p);
        inscripciones.add(inscripcion);
    }

    public static void mostrarInscriptosPorCategoria(Categoria categoria) {
        for (Inscripcion insc : inscripciones) {
            if (insc.getCategoria().getId() == categoria.getId()) {
                System.out.println(insc);
            }
        }
    }

    public static void desinscribirParticipante(String dni) {
        inscripciones.removeIf(insc -> insc.getParticipante().toString().contains(dni));
    }

    public static void calcularRecaudacion(Categoria... categorias) {
        double total = 0;
        for (Categoria c : categorias) {
            double subtotal = inscripciones.stream()
                    .filter(i -> i.getCategoria().getId() == c.getId())
                    .mapToDouble(Inscripcion::getMonto)
                    .sum();
            total += subtotal;
            System.out.println("Recaudación " + c.getNombre() + ": $" + subtotal);
        }
        System.out.println("Total recaudado en la carrera: $" + total);
    }
}
