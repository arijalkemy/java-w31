package com.mercadolibre.bootcamp;

import com.mercadolibre.bootcamp.model.Cliente;
import com.mercadolibre.bootcamp.model.Localizador;
import com.mercadolibre.bootcamp.model.Producto;
import com.mercadolibre.bootcamp.model.TipoProducto;
import com.mercadolibre.bootcamp.repository.RepositorioCliente;
import com.mercadolibre.bootcamp.repository.RepositorioLocalizador;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();

        System.out.println("====== Crear Cliente ======");
        Cliente cliente = new Cliente(1L, "001", "Mateo", "Olaya", "mateo@mercadolibre.com");
        repositorioCliente.adicionarCliente(cliente);
        System.out.println(cliente.toString());

        System.out.println();
        System.out.println("====== Punto 2: Agregar Productos ======");
        Localizador localizador = new Localizador(1L, cliente);
        Producto reservaHotel1 = new Producto(TipoProducto.RESERVA_HOTEL, 1500D);
        Producto reservaHotel2 = new Producto(TipoProducto.RESERVA_HOTEL, 1000D);
        Producto boleto1 = new Producto(TipoProducto.BOLETOS_DE_VIAJE, 2000D);
        Producto boleto2 = new Producto(TipoProducto.BOLETOS_DE_VIAJE, 3000D);

        localizador.agregarProducto(reservaHotel1);
        localizador.agregarProducto(reservaHotel2);
        localizador.agregarProducto(boleto1);
        localizador.agregarProducto(boleto2);

        System.out.println(localizador.toString());
        cliente.adicionarLocalizador(localizador);

        System.out.println();
        System.out.println("====== Punto 3: Agregar Localizador ======");
        Localizador localizador2 = new Localizador(2L, cliente);
        Producto comida = new Producto(TipoProducto.COMIDA, 1500D);
        localizador2.agregarProducto(comida);
        System.out.println(localizador2.toString());
        cliente.adicionarLocalizador(localizador2);
        System.out.println();

        if(repositorioCliente.getClienteById(1L) == null) {
            repositorioCliente.adicionarCliente(cliente);
        }
        repositorioLocalizador.agregarLocalizador(localizador);
        repositorioLocalizador.agregarLocalizador(localizador2);

        Consulta consulta1 = new Consulta(repositorioCliente, repositorioLocalizador);
        System.out.println("=== Total Ventas Previo a Descuentos ===");
        System.out.println(consulta1.totalVentas());
        System.out.println();
        System.out.println("=== Promedio Ventas Previo a Descuentos ===");
        System.out.println(consulta1.promedioVentas());


        System.out.println("====== Punto 4: Calculando Descuentos ======");
        localizador.calculaDescuentos();
        localizador2.calculaDescuentos();
        System.out.println(localizador.toString());
        System.out.println(localizador2.toString());
        System.out.println();
        System.out.println("====== Punto 5: Aplicando Persistencia ======");



        Consulta consulta = new Consulta(repositorioCliente, repositorioLocalizador);
        System.out.println("=== Producto Por Tipo ===");
        System.out.println(consulta.getProductosVendidosPorTipo());
        System.out.println();
        System.out.println("=== Total Ventas ===");
        System.out.println(consulta.totalVentas());
        System.out.println();
        System.out.println("=== Promedio Ventas ===");
        System.out.println(consulta.promedioVentas());


    }
}