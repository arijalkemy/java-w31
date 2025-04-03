package org.agencia_turismo.repository;

import org.agencia_turismo.domain.Cliente;
import org.agencia_turismo.domain.Localizador;

import java.util.List;

public interface ClientRepository <T extends Cliente> {
    void agregarCliente(Cliente cliente);
    void eliminarCliente(Cliente cliente);
    boolean buscarClientePorId(int clienteId);
    List<Localizador> buscarLocalizadorPorId(int id);
}
