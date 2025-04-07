package com.mercadolibe.AgenciaDeViajes.controller;

import com.mercadolibe.AgenciaDeViajes.model.Cliente;
import com.mercadolibe.AgenciaDeViajes.model.Localizador;
import com.mercadolibe.AgenciaDeViajes.model.Reserva;
import com.mercadolibe.AgenciaDeViajes.model.TipoReserva;
import com.mercadolibe.AgenciaDeViajes.repository.RepositorioCliente;
import com.mercadolibe.AgenciaDeViajes.repository.RepositorioLocalizador;
import com.mercadolibe.AgenciaDeViajes.service.ConsultasLocalizadores;

import java.util.Arrays;

public class AgenciaViajes {
    public static void main(String[] args) {
        // Crear repositorios
        RepositorioCliente repoCliente = new RepositorioCliente();
        RepositorioLocalizador repoLocalizador = new RepositorioLocalizador();

        // Crear cliente
        Cliente cliente = new Cliente("Juan Perez", 1);
        repoCliente.agregarCliente(cliente);

        // Crear reservas para el paquete completo
        Reserva reservaHotel = new Reserva(TipoReserva.HOTEL, 100);
        Reserva reservaComida = new Reserva(TipoReserva.COMIDA, 50);
        Reserva reservaBoleto = new Reserva(TipoReserva.BOLETO, 200);
        Reserva reservaTransporte = new Reserva(TipoReserva.TRANSPORTE, 75);

        // Crear localizador con paquete completo
        Localizador localizadorPaqueteCompleto = new Localizador(cliente, Arrays.asList(reservaHotel, reservaComida, reservaBoleto, reservaTransporte), 425);
        repoLocalizador.agregarLocalizador(localizadorPaqueteCompleto);
        localizadorPaqueteCompleto.imprimirDetalles(repoLocalizador);

        // Crear reservas para 2 hoteles y 2 boletos
        Reserva reservaHotel1 = new Reserva(TipoReserva.HOTEL, 120);
        Reserva reservaHotel2 = new Reserva(TipoReserva.HOTEL, 130);
        Reserva reservaBoleto1 = new Reserva(TipoReserva.BOLETO, 220);
        Reserva reservaBoleto2 = new Reserva(TipoReserva.BOLETO, 230);

        // Crear localizador con 2 hoteles y 2 boletos
        // aca hace el 5% de descuento por cada hotel y boleto y 5 % de futuras compras
        Localizador localizadorHotelesBoletos = new Localizador(cliente, Arrays.asList(reservaHotel1, reservaHotel2, reservaBoleto1, reservaBoleto2), 700);
        repoLocalizador.agregarLocalizador(localizadorHotelesBoletos);
        localizadorHotelesBoletos.imprimirDetalles(repoLocalizador);

        // Crear una sola reserva
        Reserva reservaUnica = new Reserva(TipoReserva.COMIDA, 60);

        // Crear localizador con una sola reserva
        Localizador localizadorUnico = new Localizador(cliente, Arrays.asList(reservaUnica), 60);
        repoLocalizador.agregarLocalizador(localizadorUnico);
        localizadorUnico.imprimirDetalles(repoLocalizador);

        ConsultasLocalizadores consultas = new ConsultasLocalizadores(repoLocalizador);

        System.out.println("------------------- CONSULTAS -------------------");

        System.out.println("Cantidad de localizadores vendidos: " + consultas.cantidadLocalizadoresVendidos());
        System.out.println("Cantidad total de reservas: " + consultas.cantidadTotalReservas());
        System.out.println("Reservas por tipo" + consultas.obtenerReservasPorTipo());
        System.out.println("Total de ventas: " + consultas.totalVentas());
        System.out.println("Promedio de ventas: " + consultas.promedioVentas());

    }
}