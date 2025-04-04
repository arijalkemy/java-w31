package dev.michellarias;

import dev.michellarias.entity.Cliente;
import dev.michellarias.entity.Localizador;
import dev.michellarias.entity.Reserva;
import dev.michellarias.enums.TipoProducto;
import dev.michellarias.repository.LocalizadorRepositoryImpl;

public class AgenciaMain {

    public static void main(String[] args) {

        LocalizadorRepositoryImpl localizadorRepository = new LocalizadorRepositoryImpl();

        Reserva hotel = new Reserva(TipoProducto.HOTEL, 1, 500D);
        Reserva boleto = new Reserva(TipoProducto.BOLETO, 1, 1000D);
        Reserva transporte = new Reserva(TipoProducto.TRANSPORTE, 1, 200D);
        Reserva comida = new Reserva(TipoProducto.COMIDA, 1, 400D);

        Cliente michell = new Cliente("123", "Michell");
        Localizador localizador = new Localizador(michell);

        // Paquete Completo
        localizador
                .addReserva(hotel)
                .addReserva(boleto)
                .addReserva(transporte)
                .addReserva(comida);

        localizadorRepository.save(localizador);

        // 2 Reservas
        Reserva hotel2 = new Reserva(TipoProducto.HOTEL, 2, 500D);
        Reserva boleto2 = new Reserva(TipoProducto.BOLETO, 2, 1000D);
        Localizador localizador2 = new Localizador(michell);
        localizador2
                .addReserva(hotel2)
                .addReserva(boleto2);
        localizadorRepository.save(localizador2);


        // 1 Sola Reserva
        Localizador localizador3 = new Localizador(michell);
        Reserva hotel3 = new Reserva(TipoProducto.HOTEL, 1, 100D);
        localizador3.addReserva(hotel3);
        localizadorRepository.save(localizador3);
        localizadorRepository.imprimirInformacion();



    }
}
