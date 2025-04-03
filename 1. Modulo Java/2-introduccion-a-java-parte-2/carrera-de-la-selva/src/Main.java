public class Main {
    public static void main(String[] args) {

        // Punto a
        Categoria circuitoChico = new Categoria("chico", 2, "selva y arroyos");
        Categoria circuitoMedio = new Categoria("medio", 5,"selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria("avanzado", 10, "selva, arroyos, barro y escalada en piedra");

        // Punto b
        Participante carlos = new Participante(123456789, 22478998, "Carlos", "Saenz", 42, "+541145567689", "+541135564579", "AB+");
        Inscripcion inscripcionCarlos = circuitoChico.insribirParticipante(carlos);

        // Punto c
        Participante maria = new Participante(987654321, 44773282, "Maria", "Perez", 16, "+541146789923", "+541145122389", "AB-");
        Participante jose = new Participante(123451234, 34118878, "Jose", "Campos", 27, "+541145122389", "+541145987139", "A+");
        Participante carla = new Participante(987659876, 24178998, "Carla", "Anticci", 18, "+541145987139", "+541131654679", "A+");

        Inscripcion inscripcionMaria = circuitoChico.insribirParticipante(maria);
        Inscripcion inscripcionJose = circuitoMedio.insribirParticipante(jose);
        Inscripcion inscripcionCarla = circuitoAvanzado.insribirParticipante(carla);

        // Punto d
        circuitoChico.mostrarInscriptos();
        circuitoMedio.mostrarInscriptos();
        circuitoAvanzado.mostrarInscriptos();

        // Punto e
        circuitoChico.desinscribirParticipante(inscripcionCarlos);
        circuitoChico.mostrarInscriptos();

        // Punto f

    }
}