package org.example.bancoAbstracto;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            runApplication();
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    private static void runApplication() {
        Scanner console = new Scanner(System.in);

        try {
            int tipoCliente = solicitarTipoCliente(console);
            Cliente cliente = createCliente(tipoCliente);

            TransaccionFactory factory = new TransaccionFactory();
            List<TIPO_TRANSACCION> transaccionesValidas = factory.getTransaccionesPermitidas(TIPO_CLIENTE.fromInt(tipoCliente));

            int tipoTransaccion = solicitarTipoTransaccion(console, transaccionesValidas);

            if (factory.isValidTransaccionForClient(TIPO_CLIENTE.fromInt(tipoCliente), TIPO_TRANSACCION.fromInt(tipoTransaccion))) {
                Transaccion transaccion = factory.createTransaccion(TIPO_TRANSACCION.fromInt(tipoTransaccion));
                // Hay un random que anula una transacción cada tanto.
                cliente.realizarTransaccion(transaccion);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int solicitarTipoCliente(Scanner console) {
        System.out.println("Iniciando la aplicacion...");
        System.out.println("Indique el tipo de cliente:\n 1- Ejecutivo\n 2- Basico\n 3- Cobrador");

        while (true) {
            try {
                int tipoCliente = Integer.parseInt(console.nextLine());
                if (tipoCliente >= 1 && tipoCliente <= 3) {
                    return tipoCliente;
                } else {
                    System.out.println("Por favor ingrese un número válido entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
            }
        }
    }

    private static int solicitarTipoTransaccion(Scanner console, List<TIPO_TRANSACCION> transaccionesValidas) {
        System.out.println("Elija el tipo de transaccion: ");
        for (TIPO_TRANSACCION type : transaccionesValidas) {
            System.out.println(type.getValor() + "-" + type);
        }

        while (true) {
            try {
                int tipoTransaccion = Integer.parseInt(console.nextLine());
                if (transaccionesValidas.contains(TIPO_TRANSACCION.fromInt(tipoTransaccion))) {
                    return tipoTransaccion;
                } else {
                    System.out.println("Por favor seleccione una transacción válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
            } catch (IllegalArgumentException e) {
                System.out.println("Transacción desconocida. Intente nuevamente.");
            }
        }
    }

    public static Cliente createCliente(int tipoCliente) {
        return switch (tipoCliente) {
            case 1 -> new Ejecutivo();
            case 2 -> new Basico();
            case 3 -> new Cobrador();
            default -> throw new IllegalArgumentException("Tipo de cliente desconocido");
        };
    }
}