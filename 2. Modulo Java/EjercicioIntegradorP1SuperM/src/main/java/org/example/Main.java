package org.example;

import org.example.model.Cliente;
import org.example.model.RepositorioCliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Cliente cliente1 = new Cliente("1","Juan","Duran");
        Cliente cliente2 = new Cliente("2", "Brayan", "Quintero");
        Cliente cliente3 = new Cliente("3", "Vanessa", "Tolosa");


        Collection<Cliente> clientes= new ArrayList<>();

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        clientes.forEach(System.out::println);

        clientes.remove(cliente2);

        System.out.println("--------Se elimina el segundo cliente--------");
        clientes.forEach(System.out::println);

        /*Pidiendo datos por scanner al usuario
        String dni = sc.nextLine();

        List<Cliente> clientesList = new ArrayList<>(clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).toList());

        if(!clientesList.isEmpty()){
            clientesList.forEach(System.out::println);
        }else{
            throw new Exception("No fue encontrado el cliente con dni: "+dni);
        }

        Item item1 = new Item("1","Computador",1,5000D);
        Item item2 = new Item("2","Tarjeta Grafica",3,1000D);
        Item item3 = new Item("3","Monitor gaming 4k", 5,500D);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        Factura factura = new Factura(cliente1,itemList);
        Collection<Factura> facturas = new ArrayList<>();


        Será necesario validar si el cliente asociado a la factura se encuentra
        registrado en la collection de clientes.
        En caso de que no, el mismo deberá ser creado


        if(clientesList.contains(factura.getCliente())){
            facturas.add(factura);
        }else{
            clientesList.add(new Cliente(factura.getCliente().getDni(),factura.getCliente().getNombre(),
                    factura.getCliente().getApellido()));
        }
*/
       usarRepositorioCliente();

    }

    public static void usarRepositorioCliente(){
        System.out.println("-----Utilización de la interfaz Crud y del repositorio Cliente.-----");

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        Cliente clienteNuevo = new Cliente("1234","Carlos","Charry");
        Cliente clienteNuevo2 = new Cliente("4567","Laura","Vanessa");

        repositorioCliente.crearCliente(clienteNuevo);
        repositorioCliente.crearCliente(clienteNuevo2);
        repositorioCliente.listarClientes();

        System.out.println("-----Actualización del cliente con id 0 y eliminación de cliente con id 1.-----");
        repositorioCliente.actualizarCliente(0,new Cliente("1234", "Charles", "Francisc"));
        repositorioCliente.eliminarCliente(1);
        repositorioCliente.listarClientes();
    }

}