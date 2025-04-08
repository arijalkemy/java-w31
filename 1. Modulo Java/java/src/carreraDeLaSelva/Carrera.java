package carreraDeLaSelva;

import java.util.ArrayList;
import java.util.List;

import static carreraDeLaSelva.Inscripcion.mostrarInscriptos;
import static carreraDeLaSelva.Inscripcion.elimiarInscriptos;

public class Carrera {
    public static void main(String[] args) {
        Categoria c1 = new Categoria(2, "por selva y arroyos");
        Categoria c2 = new Categoria(5, "por selva, arroyos y barro");
        Categoria c3 = new Categoria(10, "por selva, arroyos, barro y escalada en piedra");

        List<Inscripcion> inscripciones = new ArrayList<>();

        Participante participante1 = new Participante(1, "12345678", "Juan", "Perez", 20, "123456789", "987654321", "A+");
        inscripciones.add(new Inscripcion(1, c1, participante1));
        Participante participante2 = new Participante(2, "23456789", "Maria", "Lopez", 17, "234567890", "876543210", "O-");
        inscripciones.add(new Inscripcion(2, c2, participante2));
        Participante participante3 = new Participante(3, "34567890", "Carlos", "Martinez", 25, "345678901", "765432109", "B+");
        inscripciones.add(new Inscripcion(3, c3, participante3));

        mostrarInscriptos(inscripciones, c1);
        mostrarInscriptos(inscripciones, c2);
        mostrarInscriptos(inscripciones, c3);
        elimiarInscriptos(inscripciones,participante1);
    }
}
