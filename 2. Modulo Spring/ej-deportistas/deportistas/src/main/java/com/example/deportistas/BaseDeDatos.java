package com.example.deportistas;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Deportista;
import com.example.deportistas.model.Persona;

public class BaseDeDatos {

    static public final Persona[] personas = {
            new Persona("Pepe", "Sanchez", 30),
            new Persona("Juan", "Perez", 25),
    };

    static public final Deporte[] deportes = {
            new Deporte("Futbol", 1),
            new Deporte("Basquet", 2),
            new Deporte("Tenis", 1),
            new Deporte("Rugby", 3),
    };

    static public final Deportista[] deportistas = {

            new Deportista("Carla", "Gomez", 26, deportes[0]),
            new Deportista("Pedro", "Gonzalez", 40, deportes[0]),
            new Deportista("Maria", "Lopez", 35, deportes[2]),
    };
}
