package org.example.repository;

import org.example.model.Cliente;

import java.util.List;

public class ClienteRepository {
    List<Cliente> clienteList;

    public void addCliente(Cliente cliente){
        if(!this.clienteList.contains(cliente)){
            this.clienteList.add(cliente);
        }
    }

}
