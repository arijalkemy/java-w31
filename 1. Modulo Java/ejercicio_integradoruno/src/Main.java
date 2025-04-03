import enumeradores.Descuentos;
import enumeradores.TipoReserva;
import modelos.Cliente;
import modelos.Localizador;
import modelos.Reserva;
import repository.ClienteRepository;
import repository.LocalizadorRepository;
import servicios.ClienteService;
import servicios.LocalizadorService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService(ClienteRepository.getInstance(), LocalizadorRepository.getInstance());
        Map<Descuentos, Set<TipoReserva>> descuentosTiposReserva = Map.of(Descuentos.RESERVAS_MISMO_TIPO, Set.of(TipoReserva.HOTEL, TipoReserva.BOLETOS));

        List<Reserva> reservas = List.of(
                new Reserva(TipoReserva.HOTEL, 10),
                new Reserva(TipoReserva.VUELO, 20),
                new Reserva(TipoReserva.COMIDA, 30),
                new Reserva(TipoReserva.BOLETOS, 40),
                new Reserva(TipoReserva.TRANSPORTE, 50)
        );
        clienteService.agregarCliente(new Cliente(123456789, "Frank"));

        Localizador localizador = new Localizador(clienteService.buscarCliente(123456789), descuentosTiposReserva, reservas);
        LocalizadorService localizadorService = new LocalizadorService(LocalizadorRepository.getInstance(), localizador);

        System.out.println(localizadorService.detalles());

        reservas = List.of(new Reserva(TipoReserva.HOTEL, 10), new Reserva(TipoReserva.HOTEL, 10));

        localizador = new Localizador(clienteService.buscarCliente(123456789), descuentosTiposReserva, reservas);
        localizadorService.setLocalizador(localizador);
        System.out.println(localizadorService.detalles());

        reservas = List.of(new Reserva(TipoReserva.TRANSPORTE, 50));
        localizador = new Localizador(clienteService.buscarCliente(123456789), descuentosTiposReserva, reservas);
        localizadorService.setLocalizador(localizador);
        System.out.println(localizadorService.detalles());
    }
}