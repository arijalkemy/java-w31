package bootcamp.integrador_mañana;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Reserva reservaConPaqueteCompleto = new Reserva(true, true, true, true);
        Reserva reservaVuelo1 = new Reserva(false, false, true, false);
        Reserva reservaVuelo2 = new Reserva(false, false, true, false);
        Reserva reservaHotel1 = new Reserva(true, false, false, false);
        Reserva reservaHotel2 = new Reserva(true, false, false, false);

        Localizador localizador1 = new Localizador(1, reservaConPaqueteCompleto);
        Localizador localizador2 = new Localizador(2, reservaVuelo1);
        Localizador localizador3 = new Localizador(3, reservaVuelo2);
        Localizador localizador4 = new Localizador(4, reservaHotel1);
        Localizador localizador5 = new Localizador(5, reservaHotel2);

        List<Localizador> localizadorList1 = List.of(localizador1);
        List<Localizador> localizadorList2 = List.of(localizador2, localizador3);
        List<Localizador> localizadorList3 = List.of(localizador4, localizador5);

        Cliente cliente1 = new Cliente("Juan", 1, localizadorList1);
        Cliente cliente2 = new Cliente("David", 2, localizadorList2);
        Cliente cliente3 = new Cliente("David", 3, localizadorList3);

        //Parte 1
        cliente1.descuentoAplicado();
        cliente2.descuentoAplicado();
        cliente3.descuentoAplicado();
    }
}
