package org.meli.ejercicioDeCarreraDeSelva;


import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro.");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Carrera carrera = new Carrera();

        Participante p1 = new Participante(1, "12345678", "Juan", "Pérez", 20, "1111111111", "999999999", "O+");
        Participante p2 = new Participante(2, "87654321", "Ana", "Gómez", 16, "2222222222", "888888888", "A-");
        Participante p3 = new Participante(3, "56781234", "Carlos", "López", 25, "3333333333", "777777777", "B+");

        carrera.inscribirParticipante(circuitoChico, p1);
        carrera.inscribirParticipante(circuitoMedio, p2);
        carrera.inscribirParticipante(circuitoAvanzado, p3);

        Random random = new Random();
        for (int i = 4; i <= 6; i++) {
            int edad = random.nextInt(30) + 10;
            Participante randomP = new Participante(i, "0000000" + i, "Random" + i, "Apellido" + i, edad, "5555555" + i, "6666666" + i, "AB+");
            Categoria randomCat = (i % 3 == 0) ? circuitoAvanzado : (i % 2 == 0) ? circuitoMedio : circuitoChico;
            carrera.inscribirParticipante(randomCat, randomP);
        }

        carrera.mostrarInscriptosPorCategoria(circuitoMedio);

        carrera.desinscribirParticipante(2);

        carrera.calcularRecaudacion();
    }
}