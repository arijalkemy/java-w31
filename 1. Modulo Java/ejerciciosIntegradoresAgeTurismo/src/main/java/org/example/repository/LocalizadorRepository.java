package org.example.repository;

import org.example.model.Cliente;
import org.example.model.Localizador;

import java.util.List;

public class LocalizadorRepository {

    List<Localizador> localizadorList;

    public int obtenerNumeroLocalizadoresPorCliente(Cliente cliente){
        return this.localizadorList.stream().filter(localizador ->
                localizador.getCliente().equals(cliente)).toList().size();
    }

    /*public void clienteReservoComida(Cliente cliente){
        this.localizadorList.stream().filter(localizador ->
                localizador.getCliente().equals(cliente) &&
    }*/
}
