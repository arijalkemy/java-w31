package org.example;

import org.example.ejercicio2.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.example.ejercicio2.TipoCategoria.*;

public class Ejercicio2 {

    public static void main(String[] args) {
        Categoria catChica = new Categoria(CHICA, "Circuito Chico", 1500, 1300, false, new String[]{"Selva" , "Arroyos"}, 2.0);
        Categoria catMedia = new Categoria(MEDIANA, "Circuito Medio", 2300, 2000, false, new String[]{"Selva", "Arroyos", "Barro"}, 5.0);
        Categoria catAvanzada = new Categoria(AVANZADA, "Circuito Avanzado", 2800, 0, true, new String[]{"Selva", "Arroyos", "Barro", "Escalada en piedra"}, 10.0);

        Map<Integer, Inscripcion> inscripciones = new HashMap<>();
        Participante primerParticipante = new Participante("Carlos", "Ramirez", 12345678, 35, 11445566, 11554466, "B+");
        Inscripcion primeraInscripcion = new Inscripcion(catAvanzada, 1, primerParticipante);
        inscripciones.put(primerParticipante.getDni(), primeraInscripcion);

        for(int i = 2; i < 12; i++){
            Participante participante = RandomParticipanteGenerator.generarParticipanteAleatorio(i);
            Inscripcion inscripcion = RandomParticipanteGenerator.generarInscripcionAleatoria(i, participante, new Categoria[]{catChica, catMedia, catAvanzada});
            if (!inscripciones.containsKey(participante.getDni())) {
                inscripciones.put(participante.getDni(), inscripcion);
            }
        }

        for (Map.Entry<Integer, Inscripcion> entry : inscripciones.entrySet()) {
            System.out.println(entry.getValue().getParticipante().toString() + entry.getValue().getCategoria().printTipo());
        }


        List<Inscripcion> inscripcionesCatChica = inscripciones.values().stream().filter(inscripcion -> inscripcion.getCategoria().equals(catChica)).toList();

        System.out.println("Corredores en la categoría chica: " + inscripcionesCatChica.size());
        for (Inscripcion inscripcion : inscripcionesCatChica) {
            System.out.println(inscripcion.getParticipante().toString());
        }

        System.out.println("Eliminando a un inscripto de la categoria chica");

        int aEliminar = inscripcionesCatChica.getFirst().getParticipante().getDni();
        inscripciones.remove(aEliminar);

        inscripcionesCatChica = inscripciones.values().stream().filter(inscripcion -> inscripcion.getCategoria().equals(catChica)).toList();

        System.out.println("Corredores en la categoría chica: " + inscripcionesCatChica.size());
        for (Inscripcion inscripcion : inscripcionesCatChica) {
            System.out.println(inscripcion.getParticipante().toString());
        }

        int recaudado = inscripciones.values().stream().map(inscripcion -> inscripcion.getCategoria().getCosto(inscripcion.getParticipante().getEdad())).reduce(0, Integer::sum);
        System.out.println("El total recaudado entre todas las inscripciones: " + recaudado);

    }
}
