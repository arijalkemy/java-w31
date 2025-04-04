package dev.michellarias.repository;

import dev.michellarias.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IClientRepository {

    void save(Cliente cliente);

    Optional<Cliente> findByDni(String dni);

    void delete(Cliente cliente);

    List<Cliente> getAll();
}
