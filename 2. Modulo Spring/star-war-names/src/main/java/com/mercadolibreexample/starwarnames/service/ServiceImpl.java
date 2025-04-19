package com.mercadolibreexample.starwarnames.service;

import com.mercadolibreexample.starwarnames.Entity.Personaje;
import com.mercadolibreexample.starwarnames.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // Marca la clase como componente para que Spring la registre
public class ServiceImpl implements IService {

    private final IRepository repository;
    private List<Personaje> personajes;

    @Autowired
    public ServiceImpl(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public void loadData() {
        personajes = repository.LoadData();
    }

    @Override
    public String getName(String name) {
        Optional<Personaje> personajeOpt = personajes.stream()
                .filter(personaje -> personaje.getName().equalsIgnoreCase(name))
                .findFirst();

        return personajeOpt.map(Personaje::getName).orElse("Personaje no encontrado");
    }
}