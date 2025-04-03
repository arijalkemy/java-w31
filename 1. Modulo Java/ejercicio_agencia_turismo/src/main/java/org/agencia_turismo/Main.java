package org.agencia_turismo;

import org.agencia_turismo.domain.Cliente;
import org.agencia_turismo.domain.Localizador;
import org.agencia_turismo.domain.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reserva reservaConPaqueteCompleto = new Reserva(true, true, true, true);
        List<Localizador> localizadorList = getLocalizadors(reservaConPaqueteCompleto);

        Cliente cliente = new Cliente("Jhon", "Doe", 2121, localizadorList);

        // Parte 1.1 y 1.2 y 1.3: Almacenar e imprimir resultado
        cliente.getLocalizadores().forEach(c -> System.out.println(c.getReserva()));

        // Parte 1.4:
        cliente.dtoAplicado();
    }

    private static List<Localizador> getLocalizadors(Reserva reservaConPaqueteCompleto) {
        Reserva reservaConPaqueteIncompleto1 = new Reserva(false, true, true, true);
        Reserva reservaConPaqueteIncompleto2 = new Reserva(true, true, false, false);

        Localizador localizador = new Localizador(202020, reservaConPaqueteCompleto);
        Localizador localizador2 = new Localizador(212121, reservaConPaqueteIncompleto1);
        Localizador localizador3 = new Localizador(222222, reservaConPaqueteIncompleto2);

        List<Localizador> localizadorList = List.of(localizador, localizador2, localizador3);
        return localizadorList;
    }
}