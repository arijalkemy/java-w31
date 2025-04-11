package com.meli;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(123456789, "Morena", "Gonzalez"));
        listaClientes.add(new Cliente(987654321, "Lucas", "Perez"));
        listaClientes.add(new Cliente(456789123, "Sofia", "Rodriguez"));
        listaClientes.add(new Cliente(321654987, "Mateo", "Lopez"));
        listaClientes.add(new Cliente(654987321, "Valentina", "Garcia"));

        Scanner scanner = new Scanner(System.in);

        // Mostrar clientes
        System.out.println("----- Clientes actuales -----");
        mostrarClientes(listaClientes);

        // Eliminar cliente
        System.out.println("\n¿Desea eliminar un cliente? (1: Sí, 2: No)");
        String opcionEliminar = scanner.nextLine();

        if (opcionEliminar.equals("1")) {
            System.out.print("Ingrese DNI del cliente a eliminar: ");
            Long dniEliminar = Long.parseLong(scanner.nextLine());

            boolean eliminado = eliminarCliente(listaClientes, dniEliminar);
            if (eliminado) {
                System.out.println("Cliente eliminado correctamente.");
            } else {
                System.out.println("No se encontró el cliente a borrar.");
            }
        }

        // Buscar cliente
        System.out.println("\n¿Desea buscar un cliente? (1: Sí, 2: No)");
        String opcionBuscar = scanner.nextLine();

        if (opcionBuscar.equals("1")) {
            System.out.print("Ingrese DNI del cliente a buscar: ");
            Long dniBuscar = Long.parseLong(scanner.nextLine());

            Cliente cliente = buscarClientePorDni(listaClientes, dniBuscar);
            if (cliente != null) {
                System.out.println("---- Cliente encontrado ----");
                System.out.println("Dni: " + cliente.getDni());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
            } else {
                System.out.println("Cliente no encontrado.");
            }
        }

        // Agregar nuevo cliente
        System.out.println("\n¿Desea agregar un nuevo cliente? (1: Sí, 2: No)");
        String opcionAgregar = scanner.nextLine();

        if (opcionAgregar.equals("1")) {
            System.out.print("Ingrese DNI del nuevo cliente: ");
            Long dniNuevo = Long.parseLong(scanner.nextLine());

            Cliente existente = buscarClientePorDni(listaClientes, dniNuevo);
            if (existente != null) {
                System.out.println("El cliente ya existe: " + existente.getNombre() + " " + existente.getApellido());
            } else {
                System.out.print("Ingrese nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese apellido: ");
                String apellido = scanner.nextLine();

                listaClientes.add(new Cliente(dniNuevo, nombre, apellido));
                System.out.println("Cliente agregado correctamente.");
            }
        }

        // Mostrar lista actualizada
        System.out.println("\n----- Lista actualizada de clientes -----");
        mostrarClientes(listaClientes);
    }

    private static void mostrarClientes(List<Cliente> clientes) {
        for (Cliente c : clientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
            System.out.println();
        }
    }

    private static Cliente buscarClientePorDni(List<Cliente> clientes, Long dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    private static boolean eliminarCliente(List<Cliente> clientes, Long dni) {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente c = iterator.next();
            if (c.getDni().equals(dni)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
