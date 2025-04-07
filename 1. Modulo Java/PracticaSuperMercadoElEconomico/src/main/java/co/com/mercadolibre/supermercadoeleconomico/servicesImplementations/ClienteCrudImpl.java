package co.com.mercadolibre.supermercadoeleconomico.servicesImplementations;

import java.util.ArrayList;
import java.util.List;

import co.com.mercadolibre.supermercadoeleconomico.domain.Cliente;
import co.com.mercadolibre.supermercadoeleconomico.services.ICrud;

public class ClienteCrudImpl implements ICrud<Cliente> {

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void create(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente read(String dni) {
        for (Cliente cliente : clientes) {
            if(cliente.getDni().equalsIgnoreCase(dni)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> readAll() {
        return clientes;
    }

    @Override
    public void update(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equalsIgnoreCase(cliente.getDni())) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    @Override
    public void delete(String dni) {
        clientes.removeIf(cliente -> cliente.getDni().equalsIgnoreCase(dni));
    }
}
