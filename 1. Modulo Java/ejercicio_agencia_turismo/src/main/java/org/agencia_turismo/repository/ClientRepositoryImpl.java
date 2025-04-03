package org.agencia_turismo.repository;

import org.agencia_turismo.domain.Cliente;
import org.agencia_turismo.domain.Localizador;

import java.util.List;

public class ClientRepositoryImpl implements ClientRepository<Cliente> {

    @Override
    public void agregarCliente(Cliente cliente) {

    }

    @Override
    public void eliminarCliente(Cliente cliente) {

    }

    @Override
    public boolean buscarClientePorId(int clienteId) {
        return false;
    }

    @Override
    public List<Localizador> buscarLocalizadorPorId(int id) {
        return List.of();
    }
}
