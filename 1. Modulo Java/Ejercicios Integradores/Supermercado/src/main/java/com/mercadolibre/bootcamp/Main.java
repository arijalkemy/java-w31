package com.mercadolibre.bootcamp;

import com.mercadolibre.bootcamp.model.Cliente;
import com.mercadolibre.bootcamp.model.Factura;
import com.mercadolibre.bootcamp.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente1 = new Cliente("12345678A", "Juan", "Pérez");
        Cliente cliente2 = new Cliente("87654321B", "Ana", "Gómez");
        Cliente cliente3 = new Cliente("11223344C", "Luis", "Martínez");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        clientes.stream().forEach(System.out::println);

        System.out.println("Total de clientes: " + clientes.size());
        System.out.println();
        System.out.println("===== Eliminando 1 Cliente =====");
        clientes.remove(2);
        clientes.stream().forEach(System.out::println);

        System.out.println("Digite o dni do cliente: ");
        String dni  = scanner.nextLine();
        Optional<Cliente> cliente = clientes.stream().filter((c -> c.getDni().equals(dni))).findFirst();

        if (cliente.isPresent()) {
            Cliente encontrado = cliente.get();
            System.out.println("Cliente encontrado: " + encontrado.getNombre() +
                    " " + encontrado.getApellido() + ", DNI: " + encontrado.getDni());
        } else {
            System.out.println("Cliente con DNI " + dni + " no encontrado.");
        }

        }


        List<Factura> facturas = new ArrayList<>();
    


}