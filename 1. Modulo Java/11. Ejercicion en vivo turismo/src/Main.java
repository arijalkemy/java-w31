import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioClientes repositorio = new RepositorioClientes();

        // Simulación de uso
        Cliente cliente = repositorio.buscarCliente("Juan Perez");
        if (cliente == null) {
            cliente = repositorio.agregarCliente("Juan Perez");
        }

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva(Reserva.TipoReserva.HOTEL, 100));
        reservas.add(new Reserva(Reserva.TipoReserva.COMIDA, 50));
        reservas.add(new Reserva(Reserva.TipoReserva.BOLETO_VIAJE, 200));
        reservas.add(new Reserva(Reserva.TipoReserva.TRANSPORTE, 75));

        Localizador localizador = new Localizador(cliente, reservas);
        cliente.agregarLocalizador(localizador);

        System.out.println(localizador);
    }
}