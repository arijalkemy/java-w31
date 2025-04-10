package clasesagencia;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final Integer  VALOR_RESERVA_HOTEL = 1500;
    public static final Integer  VALOR_RESERVA_COMIDA = 500;
    public static final Integer  VALOR_RESERVA_BOLETOS = 3500;
    public static final Integer  VALOR_RESERVA_TRANSPORTE = 900;


    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(42556789, "Martin", "Perez", 0.0);
        Reserva reserva1 = new Reserva("Hotel", VALOR_RESERVA_HOTEL.intValue());
        Reserva reserva2 = new Reserva("Transporte", VALOR_RESERVA_TRANSPORTE.intValue());

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(reserva1);
        reservas.add(reserva2);


        Localizador localizador1 = new Localizador(cliente1, 0.0, reservas, 1);

        List<Localizador> localizadoresCliente1 = new ArrayList<>();
        localizadoresCliente1.add(localizador1);

        Repositorio repositorioCliente1 = new Repositorio(localizadoresCliente1);
        repositorioCliente1.mostrarLocalizadores();

        Reserva reserva3 = new Reserva("Hotel", VALOR_RESERVA_HOTEL.intValue());
        Reserva reserva4 = new Reserva("Boleto", VALOR_RESERVA_HOTEL.intValue());
        Reserva reserva5 = new Reserva("Boleto", VALOR_RESERVA_HOTEL.intValue());

        List<Reserva> reservas2 = new ArrayList<>();
        reservas2.add(reserva3);
        reservas2.add(reserva4);
        reservas2.add(reserva5);

        Localizador localizador2 = new Localizador(cliente1, 0.0, reservas2, 2);
        repositorioCliente1.addLocalizador(localizador2);


        Reserva reserva6 = new Reserva("Transporte", VALOR_RESERVA_TRANSPORTE);

        List<Reserva> reservas3 = new ArrayList<>();
        reservas3.add(reserva6);
        Localizador localizador3 = new Localizador(cliente1, 0.0, reservas3, 3);
        repositorioCliente1.addLocalizador(localizador3);

        repositorioCliente1.mostrarLocalizadores();

        System.out.println("Localizadores vendidos: " + repositorioCliente1.cantidadLocalizadores());
        System.out.println("Total de reservas: " + repositorioCliente1.cantidadReservas());

        for (Localizador localizador : localizadoresCliente1) {
            System.out.println(localizador.getTiposReservas().toString());
        }
        System.out.println("Total de ventas: " + repositorioCliente1.totalVentas());




    }
}
