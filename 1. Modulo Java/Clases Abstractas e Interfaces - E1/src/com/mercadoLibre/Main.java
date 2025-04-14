package com.mercadoLibre;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejecutivo ejecutivo = new Ejecutivo(1000);
        Basico basico = new Basico(2000);
        Cobrador cobrador = new Cobrador(3000);

        while (true) {
            System.out.println("Seleccionar un perfil:");
            System.out.println("1. Ejecutivo");
            System.out.println("2. Básico");
            System.out.println("3. Cobrador");
            System.out.println("0. Salir");

            int opcionPerfil = scanner.nextInt();
            if (opcionPerfil == 0) break;

            switch (opcionPerfil) {
                case 1:
                    operacionesEjecutivo(scanner, ejecutivo);
                    break;
                case 2:
                    operacionesBasico(scanner, basico);
                    break;
                case 3:
                    operacionesCobrador(scanner, cobrador);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static void operacionesEjecutivo(Scanner scanner, Ejecutivo ejecutivo) {
        while (true) {
            System.out.println("1. Realizar Depósito");
            System.out.println("2. Realizar Transferencia");
            System.out.println("0. Volver al menú principal");

            int opcion = scanner.nextInt();
            if (opcion == 0) break;

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    double cantidadDepositar = scanner.nextDouble();
                    ejecutivo.deposito(cantidadDepositar);
                    break;
                case 2:
                    System.out.print("Ingrese el monto a transferir: ");
                    double cantidadTransferir = scanner.nextDouble();
                    ejecutivo.transferencia(cantidadTransferir);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void operacionesBasico(Scanner scanner, Basico basico) {
        while (true) {
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Pagar Servicios");
            System.out.println("3. Retirar Efectivo");
            System.out.println("0. Volver al menú principal");

            int opcion = scanner.nextInt();
            if (opcion == 0) break;

            switch (opcion) {
                case 1:
                    basico.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Ingrese el monto a pagar: ");
                    double cantidadPagar = scanner.nextDouble();
                    basico.pagoServicios(cantidadPagar);
                    break;
                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    double cantidadRetirar = scanner.nextDouble();
                    basico.retiroEfecivo(cantidadRetirar);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void operacionesCobrador(Scanner scanner, Cobrador cobrador) {
        while (true) {
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Retirar Efectivo");
            System.out.println("0. Volver al menú principal");

            int opcion = scanner.nextInt();
            if (opcion == 0) break;

            switch (opcion) {
                case 1:
                    cobrador.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    double cantidadRetirar = scanner.nextDouble();
                    cobrador.retiroEfecivo(cantidadRetirar);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

    }
}
