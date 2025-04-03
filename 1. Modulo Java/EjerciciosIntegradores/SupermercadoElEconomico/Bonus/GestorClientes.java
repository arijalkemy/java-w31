package EjerciciosIntegradores.SupermercadoElEconomico.Bonus;

import java.util.List;
import java.util.ArrayList;

public class GestorClientes implements CRUD<Cliente> {
    private List<Cliente> clientes;

    public GestorClientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    @Override
    public void alta(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    @Override
    public Cliente consulta(Long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void modificacion(Cliente modificado) {
        for (Cliente original : clientes) {
            if (original.getDni().equals(modificado.getDni())) {
                clientes.remove(original);
                clientes.add(modificado);
                return;
            }
        }
    }

    @Override
    public void baja(Long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(id)) {
                clientes.remove(cliente);
                return;
            }
        }
    }

    @Override
    public void imprimir() {
        clientes.forEach(cliente -> System.out.println("Cliente: " + cliente.getDni() + ", Nombre: " + cliente.getNombre() + " " + cliente.getApellido()));
    }

    @Override
    public List<Cliente> getTodos() {
       return clientes;
    }

}