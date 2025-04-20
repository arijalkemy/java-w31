package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	 List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

	    //categorias
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2km por selva y arroyos.");
        Categoria circuitoMedio=new Categoria(2, "Circuito medio", "5km por selva, arroyos y barro.");
        Categoria circuitoAvanzado =new Categoria(3, "Circuito avanzado", "10km por selva, arroyos, barro y escalada en piedra.");

        //Crear participantes y registrarlos
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero de inscripciones a registrar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i < cantidad; i++){
            System.out.println("\nRegistro de participante #" + (i + 1));

            System.out.println("Numero de participante: ");
            int numeroParticipante = scanner.nextInt();
            scanner.nextLine();

            System.out.println("DNI: ");
            int dni = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.println("Apellido: ");
            String apellido= scanner.nextLine();

            System.out.println("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Celular: ");
            int celular = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Numero de emergencia: ");
            int numeroEmer = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Grupo sanguineo: ");
            String grupoSang = scanner.nextLine();

            Participante participante = new Participante(numeroParticipante, dni, nombre, apellido, edad, celular, numeroEmer, grupoSang);

            //Seleccionar categoria
            System.out.println("Seleccione la categoria (1: Circuito chico, 2: Circuito medio, 3: Circuito avanzado");
            int categoriaSelec = scanner.nextInt();
            scanner.nextLine();

            Categoria categoria = null;
            switch (categoriaSelec){
                case 1:
                    categoria = circuitoChico;
                    break;
                case 2:
                    categoria = circuitoMedio;
                    break;
                case 3:
                    categoria = circuitoAvanzado;
                    break;
                default:
                    System.out.println("Categoría no válida.");
                    continue;
            }
            if (categoria.getNombre().equalsIgnoreCase("Circuito avanzado") && edad < 18) {
                System.out.println("No se permite inscribir menores de 18 en el Circuito avanzado.");
                continue;
            }

            Inscripcion inscripcion = new Inscripcion(i+1, categoria, participante);
            inscripciones.add(inscripcion);

            System.out.println("Participante inscripto: " + participante.getNombre() +
                    " - Monto de inscripcion: $" + inscripcion.getCostoInscripcion());

        }

        //Eliminar un inscripto
        System.out.println("Ingrese numero de participante para desinscribirlo: ");
        int numeroPart = scanner.nextInt();
        scanner.nextLine();
        boolean eliminado = false;

        for(int i = inscripciones.size() -1; i>= 0; i--){
            if(inscripciones.get(i).getParticipante().getNumeroParticipante() == numeroPart ){
                inscripciones.remove(i);
                eliminado = true;
                System.out.println("Participante desinscripto exitosamente.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró un participante con ese número.");
        }
        System.out.println("/////////////////////////////////////////////////");
        System.out.println("Inscriptos: ");
        for(Inscripcion ins : inscripciones){
            System.out.println(ins.toString());
        }

        scanner.close();

        // Calcular montos
        double totalChico = 0;
        double totalMedio = 0;
        double totalAvanzado = 0;

        for (Inscripcion ins : inscripciones) {
            String nombreCat = ins.getCategoria().getNombre();
            double monto = ins.calcularMonto(ins.getCategoria(), ins.getParticipante());

            if (nombreCat.equals("Circuito chico")) {
                totalChico += monto;
            } else if (nombreCat.equals("Circuito medio")) {
                totalMedio += monto;
            } else if (nombreCat.equals("Circuito avanzado")) {
                totalAvanzado += monto;
            }
        }

        double totalGeneral = totalChico + totalMedio + totalAvanzado;

        System.out.println("/////////////////////////////////////////////////");
        System.out.println("Recaudación por categoría:");
        System.out.println("Circuito chico: $" + totalChico);
        System.out.println("Circuito medio: $" + totalMedio);
        System.out.println("Circuito avanzado: $" + totalAvanzado);
        System.out.println("Total general: $" + totalGeneral);

    }
}
