package com.mercadolibre.bootcamp.repository;

import com.mercadolibre.bootcamp.model.Cliente;

import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {

    Map<Long, Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.put(cliente.getId(), cliente);
    }

    public Cliente getClienteById(Long id) {
        return clientes.get(id);
    }


}
