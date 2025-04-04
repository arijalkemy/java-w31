package dev.michellarias.repository;

import dev.michellarias.entity.Cliente;
import dev.michellarias.entity.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocalizadorRepositoryImpl implements ILocalizadorRepository {

    private List<Localizador> localizadores;


    public LocalizadorRepositoryImpl() {
        this.localizadores = new ArrayList<>();
    }

    public List<Localizador> getAll() {
        return localizadores;
    }

    public void save(Localizador localizador) {
        calcularDescuentos(localizador);
        localizadores.add(localizador);
    }

    public List<Localizador> getByCliente(Cliente cliente) {
        return localizadores.stream()
                .filter(c -> c.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    public void calcularDescuentos(Localizador localizador) {
        int limiteDescuento = 2;
        List<Localizador> localizadoresPorCliente = getByCliente(localizador.getCliente());

        if (!localizadoresPorCliente.isEmpty() && localizadoresPorCliente.size() >= limiteDescuento) {
            localizador.calcularDescuento(true);
        }else {
            localizador.calcularDescuento(false);
        }
    }

    public void imprimirInformacion(){

        localizadores.forEach(localizador -> {
            System.out.println("------ Reservas -------");
            System.out.println("Cliente: " + localizador.getCliente().getNombre());
            localizador.getReservas().forEach(System.out::println);
            System.out.println("TOTAL: " + localizador.getTotal());
        });


    }
}