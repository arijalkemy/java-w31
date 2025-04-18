package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {
    private static List<Cliente> clientes = new ArrayList<>();

    public static Cliente obtenerORegistrarCliente(String nombre, String id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Cliente nuevo = new Cliente(nombre, id);
                    clientes.add(nuevo);
                    return nuevo;
                });
    }
}

