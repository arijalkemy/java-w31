package com.mercadoLibre;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Inscripcion> inscripcionesChico = new ArrayList<Inscripcion>();
        List<Inscripcion> inscripcionesMedio = new ArrayList<Inscripcion>();
        List<Inscripcion> inscripcionesAvanzado = new ArrayList<Inscripcion>();

        Categoria circuitoChico = new Categoria("Circuito Chico",
                2,
                "2 km por selva y arroyos.",
                1300,
                1500, inscripcionesChico);

        Categoria circuitoMedio = new Categoria("Circuito Medio",
                2,
                "5 km por selva, arroyos y barro.",
                2000,
                2300, inscripcionesMedio);

        Categoria circuitoAvanzado = new Categoria("Circuito Avanzado",
                9,
                "10 km por selva, arroyos, barro y escalada en piedra.\n",
                0,
                2800, inscripcionesAvanzado);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nCarrera de la Selva");
            System.out.println("1. Consultar circuitos");
            System.out.println("2. Agregar participante");
            System.out.println("3. Ver participantes por categoría");
            System.out.println("4. Desinscribir participante");
            System.out.println("5. Ver monto recaudado por categoría");
            System.out.println("6. Salir");
            System.out.print("Seleccionar una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    Categoria.mostrarInfoCategorias(circuitoChico, circuitoMedio, circuitoAvanzado);
                    break;

                case 2:
                    System.out.println("A continuación, ingresar los datos del participante:");
                    System.out.print("Número de participante: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Celular: ");
                    String celular = scanner.nextLine();
                    System.out.print("Celular de emergencia: ");
                    String celularEmergencia = scanner.nextLine();
                    System.out.print("Grupo sanguíneo: ");
                    String grupoSanguineo = scanner.nextLine();

                    System.out.println("\nSeleccionar el circuito para el cual se realiza la inscripcion:");
                    System.out.println("1. Circuito Chico");
                    System.out.println("2. Circuito Medio");
                    System.out.println("3. Circuito Avanzado");
                    int categoriaSeleccionada = scanner.nextInt();
                    scanner.nextLine();

                    Participante nuevoParticipante = new Participante(numero, dni, nombre, apellido, edad, celular, celularEmergencia, grupoSanguineo);
                    double montoInscripcion = 0;

                    switch (categoriaSeleccionada) {
                        case 1:
                            montoInscripcion = (nuevoParticipante.getEdad() < 18) ? circuitoChico.getCostoInscripcionMenores() : circuitoChico.getCostoInscripcionMayores();
                            Inscripcion inscripcionChico = new Inscripcion(numero, circuitoChico, nuevoParticipante, montoInscripcion);
                            circuitoChico.agregarInscripcion(inscripcionChico);
                            break;
                        case 2:
                            montoInscripcion = (nuevoParticipante.getEdad() < 18) ? circuitoMedio.getCostoInscripcionMenores() : circuitoMedio.getCostoInscripcionMayores();
                            Inscripcion inscripcionMedio = new Inscripcion(numero, circuitoMedio, nuevoParticipante, montoInscripcion);
                            circuitoMedio.agregarInscripcion(inscripcionMedio);
                            break;
                        case 3:
                            if (nuevoParticipante.getEdad() >= 18) {
                                montoInscripcion = circuitoAvanzado.getCostoInscripcionMayores();
                                Inscripcion inscripcionAvanzado = new Inscripcion(numero, circuitoAvanzado, nuevoParticipante, montoInscripcion);
                                circuitoAvanzado.agregarInscripcion(inscripcionAvanzado);
                            } else {
                                System.out.println("No se permite inscripción a menores de 18 años en el Circuito Avanzado.");
                            }
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 3:
                    System.out.println("\nSeleccionar una categoría para ver sus participantes:");
                    System.out.println("1. Circuito Chico");
                    System.out.println("2. Circuito Medio");
                    System.out.println("3. Circuito Avanzado");
                    int consultarCategoria = scanner.nextInt();
                    scanner.nextLine();

                    switch (consultarCategoria) {
                        case 1:
                            System.out.println("\nInscriptos al Circuito Chico");
                            for (Inscripcion inscripcion : circuitoChico.getInscripciones()) {
                                System.out.println("Número inscripción: " + inscripcion.getNumeroInscripcion() +
                                        ", Nombre: " + inscripcion.getParticipante().getNombre() +
                                        " " + inscripcion.getParticipante().getApellido() +
                                        ", Costo: " + inscripcion.getCostoInscripcion());
                            }
                            break;
                        case 2:
                            System.out.println("\nInscriptos en Circuito Medio:");
                            for (Inscripcion inscripcion : circuitoMedio.getInscripciones()) {
                                System.out.println("Número inscripción: " + inscripcion.getNumeroInscripcion() +
                                        ", Nombre: " + inscripcion.getParticipante().getNombre() +
                                        " " + inscripcion.getParticipante().getApellido() +
                                        ", Costo: " + inscripcion.getCostoInscripcion());
                            }
                            break;
                        case 3:
                            System.out.println("\nInscriptos en Circuito Avanzado:");
                            for (Inscripcion inscripcion : circuitoAvanzado.getInscripciones()) {
                                System.out.println("Número inscripción: " + inscripcion.getNumeroInscripcion() +
                                        ", Nombre: " + inscripcion.getParticipante().getNombre() +
                                        " " + inscripcion.getParticipante().getApellido() +
                                        ", Costo: " + inscripcion.getCostoInscripcion());
                            }
                            break;
                        default:
                            System.out.println("Categoría no válida.");
                    }
                    break;

                case 4:
                    System.out.print("\nIngresar el número de inscripción del participante a desinscribir: ");
                    int numeroInscripcionEliminar = scanner.nextInt();
                    scanner.nextLine();

                    boolean encontrado = false;

                    for (Inscripcion inscripcion : circuitoChico.getInscripciones()) {
                        if (inscripcion.getNumeroInscripcion() == numeroInscripcionEliminar) {
                            circuitoChico.eiminarInscripcion(inscripcion);
                            encontrado = true;
                            System.out.println("Participante desinscripto del Circuito Chico.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        for (Inscripcion inscripcion : circuitoMedio.getInscripciones()) {
                            if (inscripcion.getNumeroInscripcion() == numeroInscripcionEliminar) {
                                circuitoMedio.eiminarInscripcion(inscripcion);
                                encontrado = true;
                                System.out.println("Participante desinscripto del Circuito Medio.");
                                break;
                            }
                        }
                    }
                    if (!encontrado) {
                        for (Inscripcion inscripcion : circuitoAvanzado.getInscripciones()) {
                            if (inscripcion.getNumeroInscripcion() == numeroInscripcionEliminar) {
                                circuitoAvanzado.eiminarInscripcion(inscripcion);
                                encontrado = true;
                                System.out.println("Participante desinscripto del Circuito Avanzado.");
                                break;
                            }
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un participante con ese número de inscripción.");
                    }
                    break;

                case 5:
                    System.out.println("\nMonto recaudado por cada categoría:");
                    System.out.println("Circuito Chico: " + circuitoChico.calcularInscripciones());
                    System.out.println("Circuito Medio: " + circuitoMedio.calcularInscripciones());
                    System.out.println("Circuito Avanzado: " + circuitoAvanzado.calcularInscripciones());
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intentar de nuevo.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}


