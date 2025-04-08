package org.meli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // a) Categorías
        Map<String, String> categorias = new HashMap<>();
        categorias.put("Circuito chico", "2 km por selva y arroyos.");
        categorias.put("Circuito medio", "5 km por selva, arroyos y barro.");
        categorias.put("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        // Lista de Inscripciones
        // Cada inscripción es un mapa con los datos del participante
        List<Map<String, Object>> inscripciones = new ArrayList<>();

        // b) Inscribir participante
        inscribirParticipante(inscripciones, 1, 123456789, "Juan", "Pérez",
                21, "1111-1111", "1111-1111", "O+", "Circuito chico");

        // c) Inscribir participantes al azar
        inscribirParticipante(inscripciones, 2, 123456789, "Carlos", "Pérez",
                17, "1111-1111", "1111-1111", "A+", "Circuito avanzado");
        inscribirParticipante(inscripciones, 3, 123456789, "María", "Pérez",
                25, "1111-1111", "1111-1111", "O-", "Circuito chico");
        inscribirParticipante(inscripciones, 4, 123456789, "Fernanda", "Pérez",
                27, "1111-1111", "1111-1111", "A-", "Circuito medio");

        // d) Mostrar participantes inscritos
        mostrarInscripciones(inscripciones);

        // e) Desinscribir a un participante
        desinscribirParticipante(inscripciones, 2);
        mostrarInscripciones(inscripciones);

        // f) Calcular el monto total recaudado
        calcularMontos(inscripciones);
    }

    public static void inscribirParticipante(
            List<Map<String, Object>> inscripciones, int numParticipante, int dni, String nombre, String apellido,
            int edad, String celular, String numeroEmergencia, String grupoSanguineo, String categoria) {

        int monto = calcularMonto(edad, categoria);
        if (monto == -1) {
            System.out.println("No se permite inscribir participantes menores de 18 años en el Circuito avanzado.");
        }

        Map<String, Object> inscripcion = new HashMap<>();
        inscripcion.put("Número de participante", numParticipante);
        inscripcion.put("DNI", dni);
        inscripcion.put("Nombre", nombre);
        inscripcion.put("Apellido", apellido);
        inscripcion.put("Edad", edad);
        inscripcion.put("Celular", celular);
        inscripcion.put("Numero emergencia", numeroEmergencia);
        inscripcion.put("Grupo sanguíneo", grupoSanguineo);
        inscripcion.put("Categoría", categoria);
        inscripcion.put("Monto", monto);

        inscripciones.add(inscripcion);
        System.out.println("Inscripción exitosa: " + nombre + ", " + apellido + " en " + categoria + " ($" + monto + ")");
    }

    public static int calcularMonto(int edad, String categoria) {
        switch (categoria) {
            case "Circuito chico": return edad < 18 ? 1300 : 1500;
            case "Circuito medio": return edad < 18 ? 2000 : 2300;
            case "Circuito avanzado": return edad >= 18 ? 2800 : -1;
            default: return -1;
        }
    }

    public static void mostrarInscripciones(List<Map<String, Object>> inscripciones) {
        System.out.println("Inscripciones:");
        for (Map<String, Object> inscripcion : inscripciones) {
            System.out.println("Categoría: " + inscripcion.get("Categoría"));
            System.out.println("Número de participante: " + inscripcion.get("Número de participante"));
            System.out.println("DNI: " + inscripcion.get("DNI"));
            System.out.println("Nombre: " + inscripcion.get("Nombre"));
            System.out.println("Apellido: " + inscripcion.get("Apellido"));
            System.out.println("Edad: " + inscripcion.get("Edad"));
            System.out.println("Celular: " + inscripcion.get("Celular"));
            System.out.println("Grupo sanguíneo: " + inscripcion.get("Grupo sanguíneo"));
            System.out.println("Monto de inscripción: " + inscripcion.get("Monto"));
            System.out.println("----------------------------------------------");
        }
    }

    public static void desinscribirParticipante(List<Map<String, Object>> inscripciones, int numParticipante) {
        inscripciones.removeIf(
                inscripcion -> (int) inscripcion.get("Número de participante") == numParticipante);
        System.out.println("Participante con inscripción " + numParticipante + " eliminado.");
    }

    public static void calcularMontos(List<Map<String, Object>> inscripciones) {
        int total = 0;
        Map<String, Integer> montosPorCategoria = new HashMap<>();

        for (Map<String, Object> inscripcion : inscripciones) {
            String categoria = (String) inscripcion.get("Categoria");
            Integer monto = (Integer) inscripcion.get("Monto");
            montosPorCategoria.put(categoria, montosPorCategoria.getOrDefault(categoria, 0) + monto);
            total += monto;
        }

        System.out.println("Montos recaudados por categoria: ");
        for (Map.Entry<String, Integer> entry : montosPorCategoria.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
        System.out.println("Monto total recaudado en la carrera: $" + total);
    }
}