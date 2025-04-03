import clases.Client;
import clases.Localizador;
import clases.RepositorioCliente;
import clases.ReservaHotel;
import interfaces.Reserva;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Client clienteVacio = new Client("Nico", 1);
        Client cliente = new Client("Juan", 30);
        ReservaHotel reservaHotel = new ReservaHotel(10.000, 1);
        ArrayList<Reserva> reservas = new ArrayList<>();
        reservas.add(reservaHotel);



        Localizador localizador = new Localizador(cliente,reservas );
        Localizador localizadorDos = new Localizador(cliente, reservas);
        RepositorioCliente repoCliente = new RepositorioCliente();

        repoCliente.add(localizador);
        repoCliente.add(localizadorDos);

        repoCliente.getHistorialLocalizadores().forEach(loc -> loc.imprimir());



    }
}
