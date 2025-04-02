package INT_CarreraDeLaSelva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarreraDeLaSelva {
    private Map<String, List<Inscripcion>> inscripcionesPorCategoria;
    private List<Categoria> categorias;

    public CarreraDeLaSelva() {
        inscripcionesPorCategoria = new HashMap<>();
        // inicializar categorías
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Circuito chico", "2 km por selva y arroyos."));
        categorias.add(new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro."));
        categorias.add(new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra."));

        // inicializar el mapa de inscripciones
        for (Categoria categoria : categorias) {
            inscripcionesPorCategoria.put(categoria.getNombre(), new ArrayList<>());
        }
    }

    //  crear una nueva inscripción
    public void crearInscripcion(String categoriaNombre, int numero, String dni, String nombre, String apellido, int edad) {
        // verificar si la categoria existe
        List<Inscripcion> inscripciones = inscripcionesPorCategoria.get(categoriaNombre);

        // verificar si el participante ya está inscripto en la categoria
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getParticipante().dni.equals(dni)) {
                System.out.println("El participante ya está inscrito en la categoría " + categoriaNombre);
                return; // Salimos si el participante ya está inscrito
            }
        }

        // nuevo participante
        Participante participante = new Participante(numero, dni, nombre, apellido, edad);
        Inscripcion inscripcionNueva = new Inscripcion(new Categoria(0, categoriaNombre, ""), participante);
        inscripciones.add(inscripcionNueva); // Agregar la nueva inscripción
        System.out.println("Inscripción exitosa: " + inscripcionNueva.getInformacion());
    }

    // mostrar todos los inscriptos en una categoría determinada
    public void mostrarInscriptos(String categoriaNombre) {
        List<Inscripcion> inscripciones = inscripcionesPorCategoria.get(categoriaNombre);
        System.out.println("Inscriptos en " + categoriaNombre + ":");
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println(inscripcion.getInformacion()); // Muestra la información de cada inscripción
        }
    }

    // desinscribir a un participante
    public void desinscribirParticipante(String categoriaNombre, String dni) {
        List<Inscripcion> inscripciones = inscripcionesPorCategoria.get(categoriaNombre);

        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getParticipante().dni.equals(dni)) {
                inscripciones.remove(inscripcion); // Elimina la inscripción
                System.out.println("El participante " + inscripcion.getParticipante().nombre + " ha sido desinscrito de " + categoriaNombre);
                return;
            }
        }

        System.out.println("No se encontró al participante con DNI " + dni + " en la categoría " + categoriaNombre);
    }

    // calcular el monto total recaudado por cada categoría
    public void calcularMontosRecaudados() {
        double totalGeneral = 0;
        for (String categoriaNombre : inscripcionesPorCategoria.keySet()) {
            List<Inscripcion> inscripciones = inscripcionesPorCategoria.get(categoriaNombre);
            double totalCategoria = calcularTotal(inscripciones);
            totalGeneral += totalCategoria;
            System.out.println("Total recaudado en " + categoriaNombre + ": $" + totalCategoria);
        }
        System.out.println("Total recaudado en toda la carrera: $" + totalGeneral);
    }

    // calcular total de inscripciones en una categoría
    private double calcularTotal(List<Inscripcion> inscripciones) {
        double total = 0;
        for (Inscripcion inscripcion : inscripciones) {
            total += inscripcion.getMonto();
        }
        return total;
    }

    public static void main(String[] args) {
        CarreraDeLaSelva carrera = new CarreraDeLaSelva();

        // Inscribir al azar algunos participantes en diferentes categorías
        carrera.crearInscripcion("Circuito chico", 1, "12345678", "Juan", "Pérez", 21);
        carrera.crearInscripcion("Circuito medio", 2, "87654321", "Ana", "Gómez", 17);
        carrera.crearInscripcion("Circuito avanzado", 3, "23456789", "Luis", "Martínez", 22);

        // Intento de inscripción duplicada
        carrera.crearInscripcion("Circuito chico", 4, "12345678", "Juan", "Pérez", 21); // Debe mostrar que ya está inscrito

        // Mostrar inscriptos por categoría
        carrera.mostrarInscriptos("Circuito chico");
        carrera.mostrarInscriptos("Circuito medio");
        carrera.mostrarInscriptos("Circuito avanzado");

        // Desinscribir un participante
        carrera.desinscribirParticipante("Circuito chico", "12345678"); // Debería eliminar a Juan
        carrera.mostrarInscriptos("Circuito chico"); // Mostrar la lista después de la desinscripción

        // Calcular montos recaudados
        carrera.calcularMontosRecaudados();
    }
}
