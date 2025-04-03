package com.mercadolibre;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Supermercado implements CRUD<Cliente> {
    private LinkedList<Cliente> clientes = new LinkedList<>();
    private LinkedList<Factura> facturas = new LinkedList<>();

    public Supermercado() {
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void recorrerListaClientes() {
        this.clientes.stream().map(c -> "ID: " + c.getId() + ", Nombre:" + c.getNombre() + " " + c.getApellido() + ", DNI: " + c.getDni())
                .forEach(System.out::println);
    }

    public LinkedList<Producto> obtenerProductosDeCliente() {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Producto> productos = new LinkedList<>();

        System.out.println("Ingrese el número de productos que desea comprar:");
        int cantidadProductos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("Ingrese el código del producto:");
            String codigo = scanner.next();
            scanner.nextLine(); // Limpiar buffer

            System.out.println("Ingrese el nombre del producto:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la cantidad de ese producto comprada:");
            int cantidad = scanner.nextInt();

            System.out.println("Ingrese el costo unitario:");
            double costo = scanner.nextDouble();
            scanner.nextLine();

            productos.add(new Producto(codigo, nombre, cantidad, costo));
        }
        return productos;
    }


    public void crearFactura(Cliente cliente) {
        boolean existeCliente = this.clientes.stream().anyMatch(c -> c.getDni().equals(cliente.getDni()));
        if (!existeCliente) {
            Cliente c = new Cliente(cliente.getNombre(), cliente.getApellido(), cliente.getDni());
            this.clientes.add(c);
        }

        LinkedList<Producto> productos = this.obtenerProductosDeCliente();
        Factura f = new Factura(cliente, productos);


        System.out.println("Factura de: " + cliente.getNombre() + " " + cliente.getApellido() +
                " , con DNI: " + cliente.getDni() + ". Su factura tiene un total de: " +
                f.calcularTotal());
    }


    @Override
    public void realizarAlta(Cliente elemento) {
        this.clientes.add(elemento);

    }

    @Override
    public void eliminar(Cliente elemento) {
        this.clientes.remove(elemento);
    }

    @Override
    public void modificar(Cliente elemento) {
        Scanner scanner = new Scanner (System.in);
        Cliente clienteEncontrado = this.clientes.stream()
                .filter(c -> c.getId() == elemento.getId())
                .findFirst()
                .orElse(null);

        if (clienteEncontrado == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("¿Qué deseas modificar del cliente? " + clienteEncontrado.getNombre() +
                "\n 1: Nombre \n 2: Apellido \n 3: DNI");

        Integer eleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (eleccion) {
            case 1:
                System.out.println("Ingrese el nuevo nombre:");
                clienteEncontrado.setNombre(scanner.nextLine());
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido:");
                clienteEncontrado.setApellido(scanner.nextLine());
                break;
            case 3:
                System.out.println("Ingrese el nuevo DNI:");
                clienteEncontrado.setDni(scanner.nextLine());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println("Se ha modificado al cliente con éxito.");
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        Cliente clienteEncontrado = this.clientes.stream().filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getNombre() + " " +
                                 clienteEncontrado.getApellido());
        } else {
            System.out.println("Cliente no encontrado.");
        }
        return clienteEncontrado;
    }


    public void solicitarDniDeCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del usuario deseado a encontrar: ");
        String dniABuscar = scanner.next();
        Cliente clienteEncontrado = this.clientes.stream().filter(c -> c.getDni().equals(dniABuscar))
                .findFirst()
                .orElse(null);
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getNombre() + " " + clienteEncontrado.getApellido());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}
