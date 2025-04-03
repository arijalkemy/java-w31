package carreradelaselva;

public class CarreraDeLaSelva {

    public static void main(String[] args) {
        // Crear categorías Categoria(int id, String nombre, boolean permiteMenores, double montoInscripcionMenor18, double montoInscripcionMayor18) {
        Categoria circuitoChico = new Categoria(1, "Circuito Chico", true, 1500, 2000);
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", true, 2000, 2300);
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", false, 0, 2800);

        Carrera carrera = new Carrera("Carrera de la Selva", "Competencia de maratón en la selva misionera", 10);
        carrera.agregarCategoria(circuitoChico);
        carrera.agregarCategoria(circuitoMedio);
        carrera.agregarCategoria(circuitoAvanzado);

        // Crear participantes e inscribirlos
        Participante juan = new Participante(1, "12345678", "Juan", "Pérez", 25, "123456789", "987654321", "O+");
        Participante pedro = new Participante(2, "87654321", "Pedro", "Gómez", 17, "987654321", "123456789", "A+");
        Participante maria = new Participante(3, "11223344", "María", "López", 30, "456789123", "321654987", "B+");

        Inscripcion inscripcionJuan = new Inscripcion(carrera, juan, circuitoChico);
        Inscripcion inscripcionPedro = new Inscripcion(carrera, pedro, circuitoMedio);
        Inscripcion inscripcionMaria = new Inscripcion(carrera, maria, circuitoAvanzado);

        carrera.inscribirUsuarioEnCategoria(inscripcionJuan);
        carrera.inscribirUsuarioEnCategoria(inscripcionPedro);
        carrera.inscribirUsuarioEnCategoria(inscripcionMaria);

        // Mostrar inscriptos de una categoría
        System.out.println("Inscriptos en Circuito Medio:");
        System.out.println(circuitoMedio.getCantidadInscriptos() + " participantes inscriptos en circuito medio.");
        System.out.println(carrera.getCantidadInscriptos() + " participantes inscriptos en total.");

        // Desinscribir a un participante
        carrera.desinscribirUsuario(inscripcionPedro);
        System.out.println("\nDespués de desinscribir a Pedro:");
        System.out.println(circuitoMedio.getCantidadInscriptos() + " participantes inscriptos en circuito medio.");
        System.out.println(carrera.getCantidadInscriptos() + " participantes inscriptos en total.");

        // Calcular recaudaciones
        System.out.println("\nRecaudación por categoría:");
        System.out.println("Circuito Chico: $" + circuitoChico.getDineroRecaudado());
        System.out.println("Circuito Medio: $" + circuitoMedio.getDineroRecaudado());
        System.out.println("Circuito Avanzado: $" + circuitoAvanzado.getDineroRecaudado());
        System.out.println("Total recaudado en la carrera: $" + carrera.getMontoRecaudado());
    }
}
