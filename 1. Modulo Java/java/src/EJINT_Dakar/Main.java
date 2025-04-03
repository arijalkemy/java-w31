package EJINT_Dakar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500, 10000, "Gran Premio", 5);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("¿Desea agregar un vehiculo? (si/no): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                break;
            } else if (respuesta.equalsIgnoreCase("si")) {
                System.out.print("Ingrese el tipo de vehiculo (auto/moto): ");
                String tipoVehiculo = scanner.nextLine();

                System.out.print("Ingrese la velocidad: ");
                double velocidad = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese la aceleracion: ");
                double aceleracion = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese el ángulo de giro: ");
                double anguloDeGiro = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese la patente: ");
                String patente = scanner.nextLine();

                if (tipoVehiculo.equalsIgnoreCase("auto")) {
                    carrera.darDeAltaAuto(velocidad, aceleracion, anguloDeGiro, patente);
                } else if (tipoVehiculo.equalsIgnoreCase("moto")) {
                    carrera.darDeAltaMoto(velocidad, aceleracion, anguloDeGiro, patente);
                } else {
                    System.out.println("Tipo de vehiculo no válido");
                }
            } else {
                System.out.println("Opción no válida. Por favor, ingrese 'si' o 'no'");
            }
        }

        // ganador
        Vehiculo ganador = carrera.determinarGanador();
        if (ganador != null) {
            System.out.println("El ganador de la carrera es el vehiculo con patente: " + ganador.getPatente());
        }

        // socorrer un vehículo por patente
        System.out.print("Ingrese la patente del vehiculo a socorrer (auto): ");
        String patenteAuto = scanner.nextLine();
        carrera.socorrerAuto(patenteAuto);

        System.out.print("Ingrese la patente del vehiculo a socorrer (moto): ");
        String patenteMoto = scanner.nextLine();
        carrera.socorrerMoto(patenteMoto);

        scanner.close();

    }
}
