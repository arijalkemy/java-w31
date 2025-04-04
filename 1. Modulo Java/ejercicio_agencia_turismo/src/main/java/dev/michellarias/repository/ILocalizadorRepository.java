package dev.michellarias.repository;

import dev.michellarias.entity.Localizador;

import java.util.List;

public interface ILocalizadorRepository {

    List<Localizador> getAll();

    void save(Localizador localizador);
}
