package EJINT_SupermercadoElEconomico;

import java.util.ArrayList;
import java.util.List;

class ClienteCRUD implements CRUD<Cliente> {
    private List<Cliente> clientes;

    public ClienteCRUD() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void crear(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente leer(String dni) {
        return clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(cliente.getDni())) {
                clientes.set(i, cliente);
                return;
            }
        }
    }

    @Override
    public void eliminar(String dni) {
        clientes.removeIf(cliente -> cliente.getDni().equals(dni));

    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
