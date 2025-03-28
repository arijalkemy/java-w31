package org.example;

import org.example.ejercicio2.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.example.ejercicio2.TipoCategoria.*;

public class Ejercicio2 {

    public static void main(String[] args) {
        Categoria catChica = new Categoria(CHICA, "Circuito Chico", 1500, 1300, 0, new String[]{"Selva" , "Arroyos"}, 2.0);
        Categoria catMedia = new Categoria(MEDIANA, "Circuito Medio", 2300, 2000, 0, new String[]{"Selva", "Arroyos", "Barro"}, 5.0);
        Categoria catAvanzada = new Categoria(AVANZADA, "Circuito Avanzado", 2800, 0, 18, new String[]{"Selva", "Arroyos", "Barro", "Escalada en piedra"}, 10.0);

        Map<Integer, Participante> participantes = new HashMap<>();
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        Participante primerParticipante = new Participante("Carlos", "Ramirez", 12345678, 35, 11445566, 11554466, "B+");
        Inscripcion primeraInscripcion = new Inscripcion(catAvanzada, 1, primerParticipante);
        inscripciones.add(primeraInscripcion);
        participantes.put(primerParticipante.getDni(), primerParticipante);

        for(int i = 2; i < 12; i++){
            Participante participante = RandomParticipanteGenerator.generarParticipanteAleatorio(i);
            Inscripcion inscripcion = RandomParticipanteGenerator.generarInscripcionAleatoria(i, participante, new Categoria[]{catChica, catMedia, catAvanzada});
            if (!participantes.containsKey(participante.getDni())) {
                participantes.put(participante.getDni(), participante);
                inscripciones.add(inscripcion);
            }
        }

        for (Inscripcion inscripcion : inscripciones) {
            System.out.println(inscripcion.getParticipante().getDni());
        }
    }
}
