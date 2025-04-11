package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Category smallCircuit = new Category("1", "Small Circuit", "2 km por selva y arroyos.");
        Category mediumCircuit = new Category("2","Medium Circuit", "5 km por selva y arroyos.");
        Category largeCircuit = new Category("3","large Circuit", "10 km por selva y arroyos.");

        Participant p1 = new Participant("12345678A", "Juan", "Pérez", 17, "123-456-789", "Madre: Ana Pérez", "O+");
        Participant p2 = new Participant("23456789B", "María", "Gómez", 25, "987-654-321", "Padre: Luis Gómez", "A-");
        Participant p3 = new Participant("34567890C", "Carlos", "López", 16, "321-654-987", "Hermano: Pedro López", "B+");
        Participant p4 = new Participant("45678901D", "Ana", "Fernández", 30, "741-852-963", "Esposo: Juan Fernández", "AB-");
        Participant p5 = new Participant("56789012E", "Diego", "Ramírez", 14, "963-852-741", "Tío: Javier Ramírez", "O-");
        Participant p6 = new Participant("67890123F", "Laura", "Torres", 20, "852-741-963", "Hermana: Sofía Torres", "A+");
        Participant p7 = new Participant("78901234G", "Sofía", "Martínez", 17, "951-753-852", "Madre: Marta Martínez", "B-");
        Participant p8 = new Participant("89012345H", "Andrés", "Hernández", 28, "159-357-258", "Esposa: Carolina Hernández", "AB+");
        Participant p9 = new Participant("90123456I", "Valeria", "Díaz", 15, "357-258-159", "Abuela: Teresa Díaz", "O+");
        Participant p10 = new Participant("01234567J", "Roberto", "García", 19, "258-159-357", "Padre: Antonio García", "A-");


        Inscription inscription1 = new Inscription("1",p1,largeCircuit);
        Inscription inscription2 = new Inscription("2",p2,mediumCircuit);
        Inscription inscription3 = new Inscription("3",p5,smallCircuit);
        Inscription inscription4 = new Inscription("4",p6,largeCircuit);
        Inscription inscription5 = new Inscription("5",p9,smallCircuit);
        Inscription inscription6 = new Inscription("6",p10,smallCircuit);
        Inscription inscription7 = new Inscription("7",p3,smallCircuit);

        System.out.println(smallCircuit);
        System.out.println(smallCircuit.getCollectedString());

        System.out.println(mediumCircuit);
        System.out.println(mediumCircuit.getCollectedString());

        System.out.println(largeCircuit);
        System.out.println(largeCircuit.getCollectedString());

        int totalRecogido = smallCircuit.getCollected() + mediumCircuit.getCollected() + largeCircuit.getCollected();
        System.out.println("Total Recogido: " + totalRecogido) ;

    }
}