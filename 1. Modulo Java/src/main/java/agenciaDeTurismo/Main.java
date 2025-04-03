package agenciaDeTurismo;

import java.security.Key;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalizadoresRepository localizadoresRepository = new LocalizadoresRepository();
        DescuentosService descuentosService = new DescuentosService(localizadoresRepository);

        Cliente client = new Cliente("Carlos", "Ramirez", "1234");
        Reserva reservaHotel = new Reserva(1000.0, TipoReserva.HOTEL);
        Reserva reservaVuelo = new Reserva(500.0, TipoReserva.VUELO);
        Reserva reservaComida = new Reserva(200.0, TipoReserva.COMIDA);
        Reserva reservaTransporte = new Reserva(100.0, TipoReserva.TRANSPORTE);

        List<Reserva> reservasCarlos = List.of(reservaHotel, reservaVuelo, reservaComida, reservaTransporte);
        Localizadora localizadoraCarlos1 = new Localizadora(client, reservasCarlos, descuentosService);
        localizadoresRepository.storeLocalizador(localizadoraCarlos1);
        System.out.println("Precio total primera reserva: " + localizadoraCarlos1.getPrecioTotal());

        Reserva segundaReservaHotel1 = new Reserva(700.0, TipoReserva.HOTEL);
        Reserva segundaReservaHotel2 = new Reserva(800.0, TipoReserva.HOTEL);
        Reserva segundaReservaVuelo1 = new Reserva(600.0, TipoReserva.VUELO);
        Reserva segundaReservaVuelo2 = new Reserva(400.0, TipoReserva.VUELO);

        List<Reserva> segundaReservaCarlos = List.of(segundaReservaHotel1, segundaReservaHotel2, segundaReservaVuelo1, segundaReservaVuelo2);
        Localizadora localizadoraCarlos2 = new Localizadora(client, segundaReservaCarlos, descuentosService);
        localizadoresRepository.storeLocalizador(localizadoraCarlos2);

        System.out.println("Precio total segunda reserva: " + localizadoraCarlos2.getPrecioTotal());

        Reserva terceraReservaHotel = new Reserva(1000., TipoReserva.HOTEL);
        List<Reserva> terceraReservaCarlos = List.of(terceraReservaHotel);
        Localizadora localizadoraCarlos3 = new Localizadora(client, terceraReservaCarlos, descuentosService);
        localizadoresRepository.storeLocalizador(localizadoraCarlos3);
        System.out.println("Precio total tercera reserva: " + localizadoraCarlos3.getPrecioTotal());
    }
}
