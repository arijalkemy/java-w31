package org.example.model;

public interface Crud <T extends Cliente> {

     void crearCliente(T cliente);
     void actualizarCliente(int id, T cliente);
     void listarClientes();
     void eliminarCliente(int id);
}
