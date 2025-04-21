package agenciaDeTurismo;

import java.util.Arrays;
import java.util.List;

public class AgenciaDeTurismo {
    public static void main(String[] args) {
        RepositorioCliente repositorio = new RepositorioCliente();

        List<Reserva> paqueteCompleto = Arrays.asList(
                new Reserva("hotel", 100.0),
                new Reserva("comida", 50.0),
                new Reserva("boleto", 200.0),
                new Reserva("transporte", 30.0)
        );
        Localizador localizador1 = new Localizador("Juan Pérez", paqueteCompleto);
        repositorio.agregarLocalizador(localizador1);
        System.out.println("Localizador 1 - Total: " + localizador1.aplicarDescuentos(repositorio));

        List<Reserva> reservas = Arrays.asList(
                new Reserva("hotel", 100.0),
                new Reserva("hotel", 120.0),
                new Reserva("boleto", 200.0),
                new Reserva("boleto", 250.0)
        );
        Localizador localizador2 = new Localizador("Juan Pérez", reservas);
        repositorio.agregarLocalizador(localizador2);
        System.out.println("Localizador 2 - Total: " + localizador2.aplicarDescuentos(repositorio));

        List<Reserva> unaReserva = Arrays.asList(new Reserva("comida", 50.0));
        Localizador localizador3 = new Localizador("Juan Pérez", unaReserva);
        repositorio.agregarLocalizador(localizador3);
        System.out.println("Localizador 3 - Total: " + localizador3.aplicarDescuentos(repositorio));
    }
}
