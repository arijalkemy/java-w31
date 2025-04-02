import model.Categoria;
import model.Participante;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        List<Participante> participantes = List.of(
                new Participante(1, "12345678", "Juan", "Pérez", 17, "111111111", "911", "A+"),
                new Participante(2, "87654321", "Maria", "Lopez", 25, "222222222", "912", "B-"),
                new Participante(3, "11112222", "Carlos", "Gonzalez", 16, "333333333", "913", "AB+"),
                new Participante(4, "33334444", "Laura", "Martinez", 19, "444444444", "914", "O-")
        );

        Random random = new Random();

        for (Participante p : participantes) {
            try {
                if (p.getEdad() < 18) {
                    circuitoChico.agregarParticipante(p);
                } else if (p.getEdad() >= 18 && random.nextBoolean()) {
                    circuitoMedio.agregarParticipante(p);
                } else {
                    circuitoAvanzado.agregarParticipante(p);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Inscritos Circuito Chico:");
        circuitoChico.mostrarInscritos();
        System.out.println("\nInscritos Circuito Medio:");
        circuitoMedio.mostrarInscritos();
        System.out.println("\nInscritos Circuito Avanzado:");
        circuitoAvanzado.mostrarInscritos();

        System.out.println("\nDesinscribiendo al participante con número 1 del Circuito Chico");
        circuitoChico.desinscribirParticipante(1);
        circuitoChico.mostrarInscritos();

        int recaudacionChico = circuitoChico.calcularRecaudacion();
        int recaudacionMedio = circuitoMedio.calcularRecaudacion();
        int recaudacionAvanzado = circuitoAvanzado.calcularRecaudacion();
        int recaudacionTotal = recaudacionChico + recaudacionMedio + recaudacionAvanzado;

        System.out.println("\nRecaudación Total por Circuito:");
        System.out.println("Circuito Chico: $" + recaudacionChico);
        System.out.println("Circuito Medio: $" + recaudacionMedio);
        System.out.println("Circuito Avanzado: $" + recaudacionAvanzado);
        System.out.println("Recaudación Total: $" + recaudacionTotal);

    }
}
