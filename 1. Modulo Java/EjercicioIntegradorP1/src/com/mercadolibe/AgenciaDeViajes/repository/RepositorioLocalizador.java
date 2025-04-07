package com.mercadolibe.AgenciaDeViajes.repository;

import com.mercadolibe.AgenciaDeViajes.model.Cliente;
import com.mercadolibe.AgenciaDeViajes.model.Localizador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> localizadores = new ArrayList<>();

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public List<Localizador> buscarLocalizadoresPorCliente(Cliente cliente) {
        List<Localizador> resultado = new ArrayList<>();
        for (Localizador localizador : localizadores) {
            if (localizador.getCliente().getId() == cliente.getId()) {
                resultado.add(localizador);
            }
        }
        return resultado;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }
}