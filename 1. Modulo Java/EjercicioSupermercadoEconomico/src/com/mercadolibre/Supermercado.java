package com.mercadolibre;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Supermercado {
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

    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void recorrerListaClientes(){
        this.clientes.stream().map(c -> c.getNombre() + " " +  c.getApellido() + ", DNI: " + c.getDni())
                .forEach(System.out::println);
    }

    public void elimiarCliente(Cliente cliente){
        this.clientes.remove(cliente);
    }

    public void solicitarDniDeCliente(){
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



    public void crearFactura(Cliente cliente){
        boolean existeCliente = this.clientes.stream().anyMatch(c -> c.getDni().equals(cliente.getDni()));
        if(!existeCliente) {
            Cliente c = new Cliente(cliente.getNombre(), cliente.getApellido(), cliente.getDni());
            this.clientes.add(c);
        }

            LinkedList<Producto> productos = this.obtenerProductosDeCliente();
            Factura f = new Factura(cliente, productos);


            System.out.println("Factura de: " + cliente.getNombre() + " " + cliente.getApellido() +
                                " , con DNI: " + cliente.getDni() + ". Su factura tiene un total de: " +
                                f.calcularTotal());
    }
}
