package repository;

import modelos.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static List<Cliente> clientes = new ArrayList<>();
    private static ClienteRepository instance;
    private ClienteRepository() {}
    public static ClienteRepository getInstance() {
        if(instance == null) {
            instance = new ClienteRepository();
        }
        return instance;
    }

    public Cliente agregarCliente(Cliente cliente) {
        if(!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
        return cliente;
    }

    public Cliente buscarCliente(long dni) {
        return clientes.stream().filter(cliente -> cliente.getDni() == dni).findFirst().orElse(null);
    }
}
