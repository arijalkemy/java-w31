package servicios;

import modelos.Cliente;
import repository.ClienteRepository;
import repository.LocalizadorRepository;

public class ClienteService {
    private final ClienteRepository repository;
    private final LocalizadorRepository localizador;

    public ClienteService(ClienteRepository repository, LocalizadorRepository localizador) {
        this.repository = repository;
        this.localizador = localizador;
    }

    public Cliente agregarCliente(Cliente cliente) {
        repository.agregarCliente(cliente);
        return cliente;
    }

    public Cliente buscarCliente(long dni) {
        return repository.buscarCliente(dni);
    }
}
