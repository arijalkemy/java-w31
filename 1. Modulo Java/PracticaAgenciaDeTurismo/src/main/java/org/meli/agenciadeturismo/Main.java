package org.meli.agenciadeturismo;

import java.util.ArrayList;
import java.util.List;

import org.meli.agenciadeturismo.domain.Cliente;
import org.meli.agenciadeturismo.domain.Localizador;
import org.meli.agenciadeturismo.domain.Reserva;
import org.meli.agenciadeturismo.repository.ClienteRepositoryImpl;

public class Main {
    public static void main(String[] args) {


        /*
         * Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
         */
        Reserva reservaCompleta = new Reserva(true, true, true, true);
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(reservaCompleta);

        /*
         * Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
         */
        Reserva reservaParcialUno = new Reserva(true, false, false, false);
        Reserva reservaParcialDos = new Reserva(true, false, false, false);
        Reserva reservaParcialTres = new Reserva(true, false, false, false);
        Reserva reservaParcialCuatro = new Reserva(true, false, false, false);

        reservas.add(reservaParcialUno);
        reservas.add(reservaParcialDos);
        reservas.add(reservaParcialTres);
        reservas.add(reservaParcialCuatro);

        ClienteRepositoryImpl clienteRepositoryImpl = new ClienteRepositoryImpl();

        List<Localizador> localizadors = new ArrayList<>();
        localizadors.add(new Localizador(2020, reservas));

        /*Cliente para:
         * 1. Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
         * 2. Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, 
         *  e imprimir el resultado.
         */
        Cliente cliente = new Cliente("jhon", "doe", 2020202, localizadors, 0 );
        cliente.setDescuentoTotalAplicado(clienteRepositoryImpl.aplicarDescuento(cliente));



        /*
         * Crear un localizador con una sola reserva para el mismo cliente.
         */
        Reserva unicaReserva = new Reserva(false, true, false, false);
        List<Reserva> reservas2 = new ArrayList<>();
        reservas2.add(unicaReserva);
        List<Localizador> localizadors2 = new ArrayList<>();
        localizadors2.add(new Localizador(202020, reservas2));


        /*
         * Cliente para: 
         * 1. Crear un localizador con una sola reserva para el mismo cliente.
         */
        Cliente clienteConUnaReserva = new Cliente("Andres", "nulo", 20928283, localizadors2, 0);

        /*
         * Verificar que los descuentos fueron correctamente aplicados en este caso son descuentos acumulables
         */

        //Validación de descuentos aplicados al primer cliente
         System.out.println("Validación de descuentos aplicados según el cliente: \n" + cliente.toString());
        
         System.out.println("============================================================");
         //Validación de descuentos aplicados al cliente con una unica reserva
         System.out.println("Validación de descuentos aplicados según el cliente: \n" + clienteConUnaReserva.toString());
    }
}