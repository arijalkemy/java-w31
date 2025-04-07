package com.mercadolibe.AgenciaDeViajes.repository;

import com.mercadolibe.AgenciaDeViajes.model.Cliente;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {
    private Map<Integer, Cliente> clientes = new HashMap<>();

    public Cliente buscarCliente(int id) {
        return clientes.get(id);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
}