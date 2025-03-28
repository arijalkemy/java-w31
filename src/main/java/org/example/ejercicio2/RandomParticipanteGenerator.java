package org.example.ejercicio2;

import java.util.Random;

public class RandomParticipanteGenerator {
    private static final String[] NOMBRES = {"Carlos", "Marcos", "Ana", "Cesar", "Maria", "Alfonso", "Ramon", "Laura", "Mario"};
    private static final String[] APELLIDOS = {"Gomez", "Ramirez", "Lopez", "Martinez", "Perez", "Sanchez"};
    private static final String[] GRUPOS_SANGUINEOS = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
    private static final Random random = new Random();

    public static Participante generarParticipanteAleatorio(int numeroParticipante) {
        String nombre = NOMBRES[random.nextInt(NOMBRES.length)];
        String apellido = APELLIDOS[random.nextInt(APELLIDOS.length)];
        int dni = 10000000 + random.nextInt(90000000);
        int edad = 12 + random.nextInt(48);
        int celular = 1000000 + random.nextInt(9000000);
        int numeroEmergencia = 1000000 + random.nextInt(9000000);
        String grupoSanguineo = GRUPOS_SANGUINEOS[random.nextInt(GRUPOS_SANGUINEOS.length)];

        return new Participante(nombre, apellido, dni, edad, celular, numeroEmergencia, grupoSanguineo);
    }

    public static Inscripcion generarInscripcionAleatoria(int numeroInscripcion, Participante participante, Categoria[] categorias) {
        Categoria categoria = categorias[random.nextInt(categorias.length)];

        while(participante.edad < 18 && !categoria.admiteMenores()) {
            categoria = categorias[random.nextInt(categorias.length)];
        }

        return new Inscripcion(categoria, numeroInscripcion, participante);
    }




}
