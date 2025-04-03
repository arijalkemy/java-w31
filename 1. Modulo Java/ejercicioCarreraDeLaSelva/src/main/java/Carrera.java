package main.java;

public class Carrera {
    public static void main(String[] args) {
        // Crear categorías
        Categoria circuitoChico = new Categoria("Circuito chico", "2 km por selva y arroyos", 1300, 1500);
        Categoria circuitoMedio = new Categoria("Circuito medio", "5 km por selva, arroyos y barro", 2000, 2300);
        Categoria circuitoAvanzado = new Categoria("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 0, 2800); // No permite menores de 18

        // Inscribir un participante
        inscribirParticipante(circuitoChico, "12345678", "Juan", "Pérez", 21, "1234-5678", "2233-4455", "O+");
        inscribirParticipante(circuitoMedio, "87654321", "Ana", "García", 17, "9876-5432", "1122-3344", "A+");
        inscribirParticipante(circuitoAvanzado, "45678912", "Luis", "Martínez", 25, "3456-7890", "9988-7766", "B+");

        //  participante al azar
        inscribirParticipante(circuitoChico, "11223344", "Cristina", "Hernandez", 30, "3344-5566", "1234-5678", "A-");

        mostrarInscriptos(circuitoChico);
        mostrarInscriptos(circuitoMedio);
        mostrarInscriptos(circuitoAvanzado);

        // Desinscribir a un participante
        desinscribirParticipante(circuitoChico, 1); // Desinscribir el primer participante de circuitoChico

        // Mostrar inscriptos desinscripción
        mostrarInscriptos(circuitoChico);

        // Calcular y mostrar montos recaudados
        int totalGeneral = 0;
        totalGeneral += circuitoChico.calcularTotalRecaudado();
        totalGeneral += circuitoMedio.calcularTotalRecaudado();
        totalGeneral += circuitoAvanzado.calcularTotalRecaudado();

        System.out.println("Total recaudado en la carrera: $" + totalGeneral);
    };


    private static void inscribirParticipante(Categoria categoria, String dni, String nombre, String apellido, int edad, String celular, String emergencia, String grupo) {
        int monto;
        if (edad < 18) {
            monto = categoria.getPrecioMenor18();
        } else {
            monto = categoria.getPrecioMayor18();
        }

        Inscripto inscripto = new Inscripto(dni, nombre, apellido, edad, celular, emergencia, grupo, monto);
        categoria.agregarInscripto(inscripto);
    };

    private static void mostrarInscriptos(Categoria categoria) {
        System.out.println("\nInscriptos en " + categoria.getNombre() + ":");
        for (Inscripto inscripto : categoria.getInscriptos()) {
            System.out.println(inscripto);
        };
    };

    private static void desinscribirParticipante(Categoria categoria, int numeroInscripcion) {
        if (numeroInscripcion > 0 && numeroInscripcion <= categoria.getInscriptos().size()) {
            Inscripto inscripto = categoria.getInscriptos().remove(numeroInscripcion - 1);
            System.out.println("Desinscribiendo: " + inscripto);
        } else {
            System.out.println("Número de inscripción inválido.");
        }
    };
};

