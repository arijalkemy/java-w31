package exerciseIntegrador1;

import java.util.List;

import exerciseIntegrador1.clases.BoletoViaje;
import exerciseIntegrador1.clases.Cliente;
import exerciseIntegrador1.clases.Comida;
import exerciseIntegrador1.clases.Hotel;
import exerciseIntegrador1.clases.Localizador;
import exerciseIntegrador1.clases.Transporte;
import exerciseIntegrador1.repositorio.RepoCliente;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("1234", "Diego", 30);
        Localizador localizador = new Localizador(1,
                List.of(new Hotel(), new Comida(), new Transporte(), new BoletoViaje()), cliente);
        Localizador localizador2 = new Localizador(2,
                List.of(new Hotel(), new Hotel(), new BoletoViaje(), new BoletoViaje()), cliente);
        Localizador localizador3 = new Localizador(3, List.of(new Transporte()), cliente);
        RepoCliente repoCliente = new RepoCliente();
        Double total1 = repoCliente.añadirLocalizador(localizador);
        Double total2 = repoCliente.añadirLocalizador(localizador2);
        Double total3 = repoCliente.añadirLocalizador(localizador3);


        System.out.println(total1);
        System.out.println(total2);
        System.out.println(total3);

    }
}
