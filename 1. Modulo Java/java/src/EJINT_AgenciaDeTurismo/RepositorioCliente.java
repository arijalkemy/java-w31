package EJINT_AgenciaDeTurismo;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }

    public Cliente buscaCliente(String dni) {
        return clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst().orElse(null);
    }

    public void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void incrementarLocalizadores(Cliente cliente) {
        cliente.incrementarLocalizadoresC();
    }
}
