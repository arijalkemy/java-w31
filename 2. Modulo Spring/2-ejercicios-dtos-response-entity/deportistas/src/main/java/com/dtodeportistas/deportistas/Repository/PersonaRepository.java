package com.dtodeportistas.deportistas.Repository;

import com.dtodeportistas.deportistas.Model.Deporte;
import com.dtodeportistas.deportistas.Model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository {
    private List<Persona> personas = List.of(
            new Persona("Carlos", "Saenz", 43, new Deporte("Tenis", 3)),
            new Persona("Maria", "Saenz", 43, new Deporte("Futbol", 3)),
            new Persona("Marta", "Saenz", 43, new Deporte("Golf", 3))
    );

    public List<Persona> getPersonas() {
        return personas;
    }
}
