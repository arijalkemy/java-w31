package com.bootcamp.ejercicio_dtoresponseentity.repositorio;

import com.bootcamp.ejercicio_dtoresponseentity.modelo.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository{
    private static final List<Deporte> deportes = new ArrayList<>();

    public void save(Deporte deporte) {
        deportes.add(deporte);
    }

    public List<Deporte> findAll() {
        return deportes;
    }

    public Deporte findByName(String name){
        return deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
