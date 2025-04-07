import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {
    private List<Cliente> clientes;

    public RepositorioClientes() {
        this.clientes = new ArrayList<>();
    }

    public Cliente buscarCliente(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente agregarCliente(String nombre) {
        Cliente cliente = new Cliente(nombre);
        clientes.add(cliente);
        return cliente;
    }
}
