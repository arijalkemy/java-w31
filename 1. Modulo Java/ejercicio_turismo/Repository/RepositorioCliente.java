package ejercicio_turismo.Repository;

import java.util.HashMap;

import ejercicio_turismo.Model.Cliente;

public class RepositorioCliente implements Repositorio<Cliente> {
    private HashMap<Integer, Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    @Override
    public void guardar(Cliente obj) {
        if (obj != null) {
            clientes.put(obj.getId(), obj);
        }
    }

    @Override
    public HashMap<Integer, Cliente> getAll() {
        return clientes;
    }

}
