package ejercicio_turismo;

import java.util.ArrayList;

import ejercicio_turismo.Model.Cliente;
import ejercicio_turismo.Model.Localizador;
import ejercicio_turismo.Model.Reserva;
import ejercicio_turismo.Model.TipoReserva;
import ejercicio_turismo.Repository.RepositorioCliente;
import ejercicio_turismo.Repository.RepositorioLocalizador;

public class Main {
    private static Cliente cliente = new Cliente("Juan", 1);
    private static RepositorioCliente repositorioCliente = new RepositorioCliente();
    private static RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();

    public static void main(String[] args) {

        repositorioCliente.guardar(cliente);
        paqueteCompleto();
        dosHotelesDosTransporte();
        unaReserva();

        System.out.println("Cantidad de localizadores vendidos:");
        System.out.println(ParteDos.cantidadLocalizadores(repositorioLocalizador));

        System.out.println("Cantidad total de reservas:");
        System.out.println(ParteDos.cantidadReservas(repositorioLocalizador));

        System.out.println("Diccionario de reservas:");
        System.out.println(ParteDos.reservasPorTipo(repositorioLocalizador));

        System.out.println("Total de ventas:");
        System.out.println(ParteDos.totalVentas(repositorioLocalizador));

        System.out.println("Promedio de reservas por localizador:");
        System.out.println(ParteDos.promedioReservas(repositorioLocalizador));

    }

    private static void unaReserva() {
        System.out.println("Una sola reserva");

        ArrayList<Reserva> reservaSimple = new ArrayList<>();
        Reserva reserva9 = new Reserva(TipoReserva.HOTEL, 60.0);
        reservaSimple.add(reserva9);

        Localizador localizador3 = new Localizador(cliente, reservaSimple, 1);

        cliente.addLocalizador(localizador3);
        repositorioLocalizador.guardar(localizador3);

        System.out.println(localizador3);
    }

    private static void dosHotelesDosTransporte() {
        System.out.println("2 reservas de hotel y dos de transporte");

        ArrayList<Reserva> reservaHotelTransporte = new ArrayList<>();
        Reserva reserva5 = new Reserva(TipoReserva.HOTEL, 120.0);
        Reserva reserva6 = new Reserva(TipoReserva.HOTEL, 130.0);
        Reserva reserva7 = new Reserva(TipoReserva.TRANSPORTE, 220.0);
        Reserva reserva8 = new Reserva(TipoReserva.TRANSPORTE, 230.0);
        reservaHotelTransporte.add(reserva5);
        reservaHotelTransporte.add(reserva6);
        reservaHotelTransporte.add(reserva7);
        reservaHotelTransporte.add(reserva8);

        Localizador localizador2 = new Localizador(cliente, reservaHotelTransporte, 2);

        cliente.addLocalizador(localizador2);
        repositorioLocalizador.guardar(localizador2);

        System.out.println(localizador2);
    }

    private static void paqueteCompleto() {
        System.out.println("Paquete completo");

        Reserva reserva1 = new Reserva(TipoReserva.HOTEL, 100.0);
        Reserva reserva2 = new Reserva(TipoReserva.COMIDA, 50.0);
        Reserva reserva3 = new Reserva(TipoReserva.BOLETA, 200.0);
        Reserva reserva4 = new Reserva(TipoReserva.TRANSPORTE, 75.0);

        ArrayList<Reserva> reservaCompleta = new ArrayList<>();
        reservaCompleta.add(reserva1);
        reservaCompleta.add(reserva2);
        reservaCompleta.add(reserva3);
        reservaCompleta.add(reserva4);

        Localizador localizador = new Localizador(cliente, reservaCompleta, 3);

        cliente.addLocalizador(localizador);
        repositorioLocalizador.guardar(localizador);

        System.out.println(localizador);
    }
}
