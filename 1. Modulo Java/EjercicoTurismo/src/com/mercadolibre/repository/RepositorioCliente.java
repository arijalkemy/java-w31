package com.mercadolibre.repository;

import com.mercadolibre.model.Cliente;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {
    private Map<String, Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    public Cliente buscarPorDni(String dni) {
        return clientes.get(dni);
    }

    public void agregarCliente(Cliente cliente) {
        if (!clientes.containsKey(cliente.getDni())) {
            clientes.put(cliente.getDni(), cliente);
        }
    }

    public boolean existeCliente(String dni) {
        return clientes.containsKey(dni);
    }
}
