package com.mercadolibre;

public class Main {
    public static void main(String[]args){


        Participante p1 = new Participante(1, 17, 7381273, "Ornella", "Alonso", "28193321", "3894853", "0+");
        Participante p2 = new Participante(2, 25, 7381273, "Maria", "Gutierrez", "28193321", "3894853", "0+");
        Participante p3 = new Participante(3, 28, 7381273, "Lucia", "Moreno", "28193321", "3894853", "0+");
        Participante p4 = new Participante(4, 16, 7381273, "Eleonora", "Suarez", "28193321", "3894853", "0+");
        Participante p5 = new Participante(5, 30, 7381273, "Javier", "Ramirez", "28193322", "3894854", "A+");
        Participante p6 = new Participante(6, 21, 7381273, "Camila", "Fernandez", "28193323", "3894855", "B-");
        Participante p7 = new Participante(7, 18, 7381273, "Santiago", "Lopez", "28193324", "3894856", "AB+");
        Participante p8 = new Participante(8, 15, 7381273, "Valentina", "Martinez", "28193325", "3894857", "O-");
        Participante p9 = new Participante(9, 22, 7381273, "Andres", "Gonzalez", "28193326", "3894858", "B+");
        Participante p10 = new Participante(10, 19, 7381273, "Florencia", "Diaz", "28193327", "3894859", "A-");


        Inscripcion i = new Inscripcion();
        i.inscribirDeManeraRandom(p1);
        i.inscribirDeManeraRandom(p2);
        i.inscribirDeManeraRandom(p3);
        i.inscribirDeManeraRandom(p4);
        i.inscribirDeManeraRandom(p5);
        i.inscribirDeManeraRandom(p6);
        i.inscribirDeManeraRandom(p7);
        i.inscribirDeManeraRandom(p8);
        i.inscribirDeManeraRandom(p9);
        i.inscribirDeManeraRandom(p10);

        System.out.println("-----------------------------------------");
        i.inscribirDeManeraRandom(p10);

        System.out.println("-----------------------------------------");
        i.eliminarParticipante(p2);

        System.out.println("-----------------------------------------");
        System.out.println("Los participantes de la competencia son:");
        i.mostrarInscriptos();

        System.out.println("-----------------------------------------");
        i.calcularMontoPorCategoria();
        i.calcularMontoTotalEnCarrera();

    }
}
