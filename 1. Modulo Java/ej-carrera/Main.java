import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer, List<String>> categorias = new HashMap<>();
        categorias.put(1, Arrays.asList("Circuito chico", "2 km por selva y arroyos.", "1300", "1500"));
        categorias.put(2, Arrays.asList("Circuito medio", "5 km por selva, arroyos y barro.", "2000", "2300"));
        categorias.put(3, Arrays.asList("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.", "-", "2800"));

        Map<Integer, List<String>> participantes = new HashMap<>();
        participantes.put(1, Arrays.asList("Jose", "Perez", "20", "123", "1143335555", "1198887654", "A+"));
        participantes.put(2, Arrays.asList("Marcos", "Gomez", "27", "456", "1112317899", "1154678332", "A-"));
        participantes.put(3, Arrays.asList("Maria", "Jimenez", "35", "789", "1177789455", "1166789334", "AB+"));
        participantes.put(4, Arrays.asList("Juana", "Gonzalez", "25", "213", "1166557483", "1122900765", "A+"));
        participantes.put(5, Arrays.asList("Joaquin", "Gutierrez", "25", "890", "1177886354", "1122223456", "0-"));

        Map<Integer, List<Integer>> inscripciones = new HashMap<>(); // Key: id participante, value: id categoria, valor, nro inscripto
        inscripciones.put(1, Arrays.asList(2, calcularValorInscripcion(participantes.get(1), categorias.get(2)), 12));
        inscripciones.put(2, Arrays.asList(2, calcularValorInscripcion(participantes.get(2), categorias.get(2)), 32));
        inscripciones.put(3, Arrays.asList(1, calcularValorInscripcion(participantes.get(3), categorias.get(1)), 63));
        inscripciones.put(4, Arrays.asList(3, calcularValorInscripcion(participantes.get(4), categorias.get(3)), 4));
        inscripciones.put(5, Arrays.asList(2, calcularValorInscripcion(participantes.get(5), categorias.get(2)), 23));

        mostrarParticipantesDeXCategoria(inscripciones, participantes, 2);
        inscripciones.remove(2);
        mostrarParticipantesDeXCategoria(inscripciones, participantes, 2);

        calcularYMostrarRecaudacionDeXCategoria(inscripciones, 2);
        calcularYMostrarRecaudacionesTotales(inscripciones);
    }

    private static int calcularValorInscripcion(List<String> participante, List<String> categoria) {
        if (Integer.parseInt(participante.get(2)) < 18 && categoria.get(2) != "-") {
            return Integer.parseInt(categoria.get(2));
        }
        else {
            return Integer.parseInt(categoria.get(3));
        }
    }

    private static void mostrarParticipantesDeXCategoria(Map<Integer, List<Integer>> inscripciones, Map<Integer, List<String>> participantes, int categoriaId) {
        for ( Map.Entry<Integer, List<Integer>> inscripcion : inscripciones.entrySet()) {
            int categoriaIdDeInscripcion = inscripcion.getValue().get(0);
            if (categoriaIdDeInscripcion == categoriaId){
                Integer participanteId = inscripcion.getKey();
                List<String> participante = participantes.get(participanteId);
                System.out.println(participante.get(0) + " " + participante.get(1) + " " + participante.get(2) + " - nro. inscripto: " + inscripcion.getValue().get(2));
            }
        }
    }

    private static void calcularYMostrarRecaudacionDeXCategoria(Map<Integer, List<Integer>> inscripciones, int categoriaId) {
        int recaudacion = 0;
        for ( Map.Entry<Integer, List<Integer>> inscripcion : inscripciones.entrySet()) {
            if (inscripcion.getValue().get(0) == categoriaId) {
                recaudacion += inscripcion.getValue().get(1);
            }
        }
        System.out.println("El total de recaudacion para la categoria " + categoriaId + " fue de $" + recaudacion);
    }

    private static void calcularYMostrarRecaudacionesTotales(Map<Integer, List<Integer>> inscripciones) {
        int recaudacion = 0;
        for ( Map.Entry<Integer, List<Integer>> inscripcion : inscripciones.entrySet()) {
            recaudacion += inscripcion.getValue().get(1);
        }
        System.out.println("El total de recaudacion para la carrera fue de $" + recaudacion);
    }
}