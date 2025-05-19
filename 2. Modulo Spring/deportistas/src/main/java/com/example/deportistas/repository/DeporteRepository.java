package com.example.deportistas.repository;

import com.example.deportistas.entity.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository {
    public static List<Deporte> deportes = new ArrayList<>();

    static{
        deportes.add(new Deporte("Futbol", "Avanzado"));
        deportes.add(new Deporte("Handball", "Intermedio"));
    }

    public List<Deporte> findAll(){
        return deportes;
    }

    public Deporte findByName(String nombre){
        return deportes.stream().filter(d->d.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }


}
