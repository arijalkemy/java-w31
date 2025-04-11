package com.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Categoria CircuitoChico = new Categoria(101, "Circuito Chico", "2Km por selva y arroyos");
        Categoria CircuitoMedio = new Categoria(202, "Circuito Medio", "5Km por selva, arroyos y barro");
        Categoria CircuitoAvanzado = new Categoria(303, "Circuito Avanzado", "10Km por selva, arroyos, barro y escalada en piedra");



        Participante p1 = new Participante("Julia", "Maraulo", 20, 46019748, 1121626929, 1121626929, "0+" );
        Participante p2 = new Participante("Lucas", "Alvez", 26, 46019649, 1121626928, 1121126928, "A+" );
        Participante p3 = new Participante("Lola", "Lolita", 18, 46019650, 1121626927, 1121626127, "AB+" );
        Participante p4 = new Participante("Lucia", "Maraulo", 20, 46019748, 1121526929, 1121616929, "0+" );
        Participante p5 = new Participante("Martina", "Alvez", 26, 46019649, 1121627928, 1121626928, "A+" );
        Participante p6 = new Participante("Lucinao", "Lolita", 18, 46019650, 1121686927, 1111626927, "AB+" );
      

        Inscripcion i1 = new Inscripcion(CircuitoChico, p1);
        Inscripcion i2 = new Inscripcion(CircuitoMedio, p2);
        Inscripcion i3 = new Inscripcion(CircuitoAvanzado, p3);
        Inscripcion i4 = new Inscripcion(CircuitoChico, p4);
        Inscripcion i5 = new Inscripcion(CircuitoMedio, p5);
        Inscripcion i6 = new Inscripcion(CircuitoAvanzado, p6);


        // Imprimir resultados
        System.out.println("ID del participante: " + p1.getIdParticipante()+ "/ ID de Inscripción: " + i1.getIdInscripcion() + ", Categoría: " + i1.getCategoria() + ", Monto a pagar: " + i1.getMontoInscripcion());
        System.out.println("ID del participante: " + p2.getIdParticipante()+ "/ ID de Inscripción: " + i2.getIdInscripcion() + ", Categoría: " + i2.getCategoria() + ", Monto a pagar: " + i2.getMontoInscripcion());
        System.out.println("ID del participante: " + p3.getIdParticipante()+ "/ ID de Inscripción: " + i3.getIdInscripcion() + ", Categoría: " + i3.getCategoria() + ", Monto a pagar: " + i3.getMontoInscripcion());
        System.out.println("ID del participante: " + p4.getIdParticipante()+ "/ ID de Inscripción: " + i4.getIdInscripcion() + ", Categoría: " + i4.getCategoria() + ", Monto a pagar: " + i4.getMontoInscripcion());
        System.out.println("ID del participante: " + p5.getIdParticipante()+ "/ ID de Inscripción: " + i5.getIdInscripcion() + ", Categoría: " + i5.getCategoria() + ", Monto a pagar: " + i5.getMontoInscripcion());
        System.out.println("ID del participante: " + p6.getIdParticipante()+ "/ ID de Inscripción: " + i6.getIdInscripcion() + ", Categoría: " + i6.getCategoria() + ", Monto a pagar: " + i6.getMontoInscripcion());
        System.out.println("--------------------------------------------------");
        // Pedir al usuario que elija una categoría
       
        // Guardar inscripciones en un array
        Inscripcion[] inscripciones = {i1, i2, i3, i4, i5, i6};


        // Pedir al usuario que ingrese una categoría para mostrar los inscriptos
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la categoría que desea consultar (101, 202, 303): ");
        int idCategoria = scanner.nextInt();


        // Llamar a la función para mostrar inscriptos en la categoría elegida
        MostrarPorCategoria(inscripciones, idCategoria);

    
        // Llamar a la función para eliminar la inscripción
        System.out.print("Ingrese el ID de la inscripción que desea eliminar: ");
        int idInscripcion = scanner.nextInt();
        EliminarInscripcion(inscripciones, idInscripcion);
        scanner.close();

         // Mostramos nuevamente los inscriptos en la categoría elegida
        MostrarPorCategoria(inscripciones, idCategoria);

       // Calculamos la recaudación
        CalcularRecaudacion(inscripciones);
    }
    //MOSTRAR POR CATEGORIA
    public static void MostrarPorCategoria(Inscripcion[] inscripciones, int idCategoria) {
        System.out.println("Inscripciones en la categoría " + idCategoria + ":");
        System.out.println("--------------------------------------------------");
        boolean encontrado = false;
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion != null && inscripcion.getCategoria().getIdCategoria() == idCategoria) {
                Participante p = inscripcion.getParticipante();
                System.out.println("ID de inscripción: " + inscripcion.getIdInscripcion());
                System.out.println("Nombre y apellido: " + p.getNombre() + " " + p.getApellido());
                System.out.println("Más info: " + p.getEdad() + " años, DNI n°: " + p.getDni());
                System.out.println("----------------------");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay inscriptos en esta categoría.");
        }
    }
    
    // ELIMINAR INSCRIPCION
    public static void EliminarInscripcion(Inscripcion[] inscripciones, int idInscripcion) {
        boolean encontrado = false;
        for (int i = 0; i < inscripciones.length; i++) {
            if (inscripciones[i].getIdInscripcion() == idInscripcion) {
                inscripciones[i] = null;
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("--------------------------------------------------");
            System.out.println("La inscripción con el ID " + idInscripcion + " ha sido eliminada.");
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("No se encontró una inscripción con el ID " + idInscripcion + ".");
        }
    }

    // CALCULAMOS TOTALES
    public static void CalcularRecaudacion(Inscripcion[] inscripciones) {
        double totalChico = 0;
        double totalMedio = 0;
        double totalAvanzado = 0;
    
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion != null) {
                int idCategoria = inscripcion.getCategoria().getIdCategoria();
                double monto = inscripcion.getMontoInscripcion();
                if (idCategoria == 101) {
                    totalChico += monto;
                } else if (idCategoria == 202) {
                    totalMedio += monto;
                } else if (idCategoria == 303) {
                    totalAvanzado += monto;
                }
            }
        }
        double totalGeneral = totalChico + totalMedio + totalAvanzado;
        System.out.println("Recaudación por categoría");
        System.out.println("Circuito Chico (101): $" + totalChico);
        System.out.println("Circuito Medio (202): $" + totalMedio);
        System.out.println("Circuito Avanzado (303): $" + totalAvanzado);
        System.out.println("----------------------------------");
        System.out.println("TOTAL GENERAL: $" + totalGeneral);
    }
    

}