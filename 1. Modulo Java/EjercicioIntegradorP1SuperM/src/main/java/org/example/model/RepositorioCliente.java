package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements Crud<Cliente>{
    private List<Cliente> clienteList = new ArrayList<>();

    @Override
    public void crearCliente(Cliente cliente) {
        clienteList.add(cliente);
    }

    @Override
    public void actualizarCliente(int id, Cliente cliente) {
        this.clienteList.get(id).setDni(cliente.getDni());
        this.clienteList.get(id).setNombre(cliente.getNombre());
        this.clienteList.get(id).setApellido(cliente.getApellido());
    }

    @Override
    public void eliminarCliente(int id) {
        this.clienteList.remove(id);
    }

    @Override
    public void listarClientes() {
        this.clienteList.forEach(System.out::println);
    }
}
