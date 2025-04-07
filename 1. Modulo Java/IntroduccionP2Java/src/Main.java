//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // punto a
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1 = new Participante(1, "12345678", "Juan", "Perez", 21, "123456789", "987654321", "A+");
        Participante participante2 = new Participante(2, "87654321", "Maria", "Gomez", 17, "987654321", "123456789", "B-");
        Participante participante3 = new Participante(3, "11223344", "Carlos", "Lopez", 25, "1122334455", "5544332211", "O+");

        Inscripcion inscripcion1 = new Inscripcion(1, circuitoChico, participante1, Carrera.calcularMonto(circuitoChico, participante1));
        Inscripcion inscripcion2 = new Inscripcion(2, circuitoMedio, participante2, Carrera.calcularMonto(circuitoMedio, participante2));
        Inscripcion inscripcion3 = new Inscripcion(3, circuitoAvanzado, participante3, Carrera.calcularMonto(circuitoAvanzado, participante3));

        // punto b
        Carrera carrera = new Carrera();
        carrera.inscribirParticipante(inscripcion1);
        carrera.inscribirParticipante(inscripcion2);
        carrera.inscribirParticipante(inscripcion3);

        //punto c
        System.out.println("Inscripciones en Circuito Chico:");
        carrera.mostrarInscripcionesPorCategoria(circuitoChico);

        System.out.println("Inscripciones en Circuito Medio:");
        carrera.mostrarInscripcionesPorCategoria(circuitoMedio);

        System.out.println("Inscripciones en Circuito Avanzado:");
        carrera.mostrarInscripcionesPorCategoria(circuitoAvanzado);

        // punto d
        carrera.desinscribirParticipante(participante1);
        System.out.println("Inscripciones en Circuito Chico después de desinscribir a Juan Perez:");
        carrera.mostrarInscripcionesPorCategoria(circuitoChico);

        // Calcular montos totales
        System.out.println("Monto total recaudado en Circuito Chico: $" + carrera.calcularMontoTotalPorCategoria(circuitoChico));
        System.out.println("Monto total recaudado en Circuito Medio: $" + carrera.calcularMontoTotalPorCategoria(circuitoMedio));
        System.out.println("Monto total recaudado en Circuito Avanzado: $" + carrera.calcularMontoTotalPorCategoria(circuitoAvanzado));
        System.out.println("Monto total recaudado en toda la carrera: $" + carrera.calcularMontoTotal());
    }
}
