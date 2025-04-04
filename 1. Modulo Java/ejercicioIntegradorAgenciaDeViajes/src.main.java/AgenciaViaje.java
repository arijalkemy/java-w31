import java.util.Arrays;

public class AgenciaViaje {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Jose", "Perez", "12345678");
        RepositorioCliente repoCliente = new RepositorioCliente();
        repoCliente.agregarCliente(cliente);

        Reserva reservaHotel = new Reserva(1000D, "Hotel");
        Reserva reservaBoleto = new Reserva(200D, "Boleto");
        Reserva reservaComida = new Reserva(500D, "Comida");
        Reserva reservaTransporte = new Reserva(300D, "Transporte");

        Localizador localizadorCompleto = new Localizador(cliente, Arrays.asList(reservaHotel,reservaComida,reservaBoleto,reservaTransporte), repoCliente);
        repoCliente.agregarLocalizador(localizadorCompleto);
        System.out.println(localizadorCompleto.toString());

        System.out.println("-----------------------------------");

        Reserva reservaHotel1 = new Reserva(2000D, "Hotel");
        Reserva reservaHotel2 = new Reserva(2500D, "Hotel");
        Reserva reservaBoleto1 = new Reserva(200D, "Boleto");
        Reserva reservaBoleto2 = new Reserva(800D, "Boleto");

        Localizador localizadorDosYDos = new Localizador(cliente, Arrays.asList(reservaHotel1, reservaHotel2, reservaBoleto1, reservaBoleto2), repoCliente);
        repoCliente.agregarLocalizador(localizadorDosYDos);
        System.out.println(localizadorDosYDos.toString());

        System.out.println("-----------------------------------");

        Reserva reservaUnica = new Reserva(400D, "Comida");

        Localizador localizadorReservaUnica = new Localizador(cliente, Arrays.asList(reservaUnica), repoCliente);
        repoCliente.agregarLocalizador(localizadorReservaUnica);
        System.out.println(localizadorReservaUnica.toString());

        System.out.println("-----------------------------------");

        System.out.println("Se vendieron " + repoCliente.cantidadDeLocalizadoresVendidos() + " localizadores.");

        System.out.println("-----------------------------------");

        System.out.println("Se hicieron " + repoCliente.cantidadDeReservas() + " reservas.");

        System.out.println("-----------------------------------");

        System.out.println("Reservas por tipo " + repoCliente.reservasPorTipo());

        System.out.println("-----------------------------------");

        System.out.println("Reservas por tipo " + repoCliente.reservasPorTipo());

        System.out.println("-----------------------------------");

        System.out.println("El total de ventas es: " + repoCliente.obtenerTotalVentas());

        System.out.println("-----------------------------------");

        System.out.println("El promedio de ventas es: " + repoCliente.obtenerPromedioVentas());
        }
        }
