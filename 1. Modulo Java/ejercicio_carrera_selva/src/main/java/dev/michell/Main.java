package dev.michell;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Categoria categoriaChica = new Categoria(1, CategoriasEnum.CHICO, "Circuito Chico");
        Categoria categoriaMedia = new Categoria(2, CategoriasEnum.MEDIO, "Circuito Media");
        Categoria categoriaAvanzado = new Categoria(3, CategoriasEnum.AVANZADO, "Circuito Avanzado");


        Participante hellen = new Participante(1432564, "Hellen", 21);
        Participante michell = new Participante(412312, "Michell", 25);
        Participante carlos = new Participante(52434, "Carlos", 15);
        Participante felipe = new Participante(432353, "Felipe", 18);
        Participante alejandro = new Participante(987985, "Alejandro", 18);
        Participante manuel = new Participante(1987562, "Manuel", 38);


        Inscripcion inscripcionHellen = new Inscripcion(hellen);
        Inscripcion inscripcionMichell = new Inscripcion(michell);
        Inscripcion inscripcionCarlos = new Inscripcion(carlos);
        Inscripcion inscripcionFelipe = new Inscripcion(felipe);
        Inscripcion inscripcionAlejandro = new Inscripcion(alejandro);
        Inscripcion inscripcionManuel = new Inscripcion(manuel);


        categoriaChica
                .agregarInscripcion(inscripcionHellen)
                .agregarInscripcion(inscripcionCarlos);

        categoriaMedia
                .agregarInscripcion(inscripcionMichell)
                .agregarInscripcion(inscripcionFelipe);

        categoriaAvanzado
                .agregarInscripcion(inscripcionAlejandro)
                .agregarInscripcion(inscripcionManuel);



        categoriaChica.mostrarInscripciones();

        categoriaChica.eliminarInscripcion(inscripcionHellen.getNumero());

        categoriaChica.mostrarInscripciones();

        System.out.println("Monto Total dev.michell.Categoria Chica: " + categoriaChica.calcularMontoTotal());

        // Calculamos el total de la carrera
        Map<Categoria, Double> categorias = new HashMap<>();
        categorias.put(categoriaChica, categoriaChica.calcularMontoTotal());
        categorias.put(categoriaMedia, categoriaMedia.calcularMontoTotal());
        categorias.put(categoriaAvanzado, categoriaAvanzado.calcularMontoTotal());

        double montoTotalCarrera = 0;
        for (Map.Entry<Categoria, Double> categoria : categorias.entrySet()) {
            montoTotalCarrera += categoria.getValue();
        }

        System.out.println("Monto Total Carreras: " + montoTotalCarrera);
    }
}
