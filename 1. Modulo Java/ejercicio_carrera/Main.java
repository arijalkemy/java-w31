import java.util.ArrayList;

public class Main {
    public static ArrayList<Inscripcion> inscripciones1 = new ArrayList<>();
    public static ArrayList<Inscripcion> inscripciones2 = new ArrayList<>();
    public static ArrayList<Inscripcion> inscripciones3 = new ArrayList<>();

    public static void main(String[] args) {
        Categoria categoria1 = new Categoria(1);
        Categoria categoria2 = new Categoria(2);
        Categoria categoria3 = new Categoria(3);

        Participante participante1 = new Participante(1, 12345678, "Juan", "Pérez", 25, "123456789", "987654321", "O+");
        Participante participante2 = new Participante(2, 87654321, "Ana", "Gómez", 17, "987654321", "123456789", "A+");
        Participante participante3 = new Participante(3, 11223344, "Carlos", "López", 30, "111222333", "444555666",
                "B+");
        Participante participante4 = new Participante(4, 55667788, "María", "Martínez", 22, "222333444", "555666777",
                "O-");
        Participante participante5 = new Participante(5, 99887766, "Luis", "García", 28, "333444555", "666777888",
                "AB+");
        Participante participante6 = new Participante(6, 44332211, "Sofía", "Hernández", 19, "444555666", "777888999",
                "A-");
        Participante participante7 = new Participante(7, 66778899, "Miguel", "Torres", 35, "555666777", "888999000",
                "B-");
        Participante participante8 = new Participante(8, 22334455, "Laura", "Ramírez", 26, "666777888", "999000111",
                "O+");
        Participante participante9 = new Participante(9, 77889900, "Diego", "Flores", 21, "777888999", "000111222",
                "AB-");
        Participante participante10 = new Participante(10, 33445566, "Camila", "Vargas", 24, "888999000", "111222333",
                "A+");
        Participante participante11 = new Participante(11, 88990011, "Javier", "Castro", 29, "999000111", "222333444",
                "O-");
        Participante participante12 = new Participante(12, 44556677, "Valeria", "Morales", 18, "000111222", "333444555",
                "B+");

        Inscripcion inscripcion1 = new Inscripcion(1, categoria1, participante1);
        inscripciones1.add(inscripcion1);
        Inscripcion inscripcion2 = new Inscripcion(2, categoria2, participante2);
        inscripciones2.add(inscripcion2);
        Inscripcion inscripcion3 = new Inscripcion(3, categoria3, participante3);
        inscripciones3.add(inscripcion3);
        Inscripcion inscripcion4 = new Inscripcion(4, categoria1, participante4);
        inscripciones1.add(inscripcion4);
        Inscripcion inscripcion5 = new Inscripcion(5, categoria2, participante5);
        inscripciones2.add(inscripcion5);
        Inscripcion inscripcion6 = new Inscripcion(6, categoria3, participante6);
        inscripciones3.add(inscripcion6);
        Inscripcion inscripcion7 = new Inscripcion(7, categoria1, participante7);
        inscripciones1.add(inscripcion7);
        Inscripcion inscripcion8 = new Inscripcion(8, categoria2, participante8);
        inscripciones2.add(inscripcion8);
        Inscripcion inscripcion9 = new Inscripcion(9, categoria3, participante9);
        inscripciones3.add(inscripcion9);
        Inscripcion inscripcion10 = new Inscripcion(10, categoria1, participante10);
        inscripciones1.add(inscripcion10);
        Inscripcion inscripcion11 = new Inscripcion(11, categoria2, participante11);
        inscripciones2.add(inscripcion11);
        Inscripcion inscripcion12 = new Inscripcion(12, categoria3, participante12);
        inscripciones3.add(inscripcion12);

        // Mostrar inscripciones
        // Categoria chica
        System.out.println("Inscripciones de la categoría chica:");
        for (Inscripcion inscripcion : inscripciones1) {
            System.out.println("Inscripción: " + inscripcion.numeroInscripcion);
            System.out.println(
                    "Participante: " + inscripcion.participante.nombre + " " + inscripcion.participante.apellido
                            + " numero de participante: " + inscripcion.participante.numero);
            System.out.println();
        }
        // Categoria media
        System.out.println("Inscripciones de la categoría media:");
        for (Inscripcion inscripcion : inscripciones2) {
            System.out.println("Inscripción: " + inscripcion.numeroInscripcion);
            System.out.println(
                    "Participante: " + inscripcion.participante.nombre + " " + inscripcion.participante.apellido
                            + " numero de participante: " + inscripcion.participante.numero);
            System.out.println();
        }
        // Categoria avanzada
        System.out.println("Inscripciones de la categoría avanzada:");
        for (Inscripcion inscripcion : inscripciones3) {
            System.out.println("Inscripción: " + inscripcion.numeroInscripcion);
            System.out.println(
                    "Participante: " + inscripcion.participante.nombre + " " + inscripcion.participante.apellido
                            + " numero de participante: " + inscripcion.participante.numero);
            System.out.println();
        }

        // desinscribir a alguien
        System.out.println("Desinscribiendo a la segunda inscripción de la categoría media:");
        inscripciones2.remove(1);
        for (Inscripcion inscripcion : inscripciones2) {
            System.out.println("Inscripción: " + inscripcion.numeroInscripcion);
            System.out.println(
                    "Participante: " + inscripcion.participante.nombre + " " + inscripcion.participante.apellido
                            + " numero de participante: " + inscripcion.participante.numero);
            System.out.println();
        }

        // calcular monto
        int montoCategoria1 = 0;
        for (Inscripcion inscripcion : inscripciones1) {
            montoCategoria1 += inscripcion.monto;
        }
        System.out.println("Monto total de la categoría chica: " + montoCategoria1);
        int montoCategoria2 = 0;
        for (Inscripcion inscripcion : inscripciones2) {
            montoCategoria2 += inscripcion.monto;
        }
        System.out.println("Monto total de la categoría media: " + montoCategoria2);
        int montoCategoria3 = 0;
        for (Inscripcion inscripcion : inscripciones3) {
            montoCategoria3 += inscripcion.monto;
        }
        System.out.println("Monto total de la categoría avanzada: " + montoCategoria3);
        // calcular monto total
        int montoTotal = montoCategoria1 + montoCategoria2 + montoCategoria3;
        System.out.println("Monto total de todas las categorías: " + montoTotal);
    }
}
