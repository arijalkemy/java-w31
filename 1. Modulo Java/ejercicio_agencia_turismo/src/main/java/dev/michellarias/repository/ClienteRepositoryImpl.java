package dev.michellarias.repository;

import dev.michellarias.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositoryImpl implements IClientRepository{

    List<Cliente> clientes;


    public ClienteRepositoryImpl() {
        this.clientes = new ArrayList<>();
    }

    public void save(Cliente cliente) {
        Optional<Cliente> clienteExiste = findByDni(cliente.getDni());
        if (clienteExiste.isPresent()) {
            throw new RuntimeException("Cliente existe en el sistema");
        }

        clientes.add(cliente);
    }

    public Optional<Cliente> findByDni(String dni) {
        return clientes.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst();
    }

    public void delete(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> getAll() {
        return clientes;
    }
}