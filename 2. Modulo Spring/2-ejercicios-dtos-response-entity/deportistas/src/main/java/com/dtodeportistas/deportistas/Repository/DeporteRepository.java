package com.dtodeportistas.deportistas.Repository;

import com.dtodeportistas.deportistas.Model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeporteRepository {
    private List<Deporte> deportes = List.of(
            new Deporte("Tenis", 8),
            new Deporte("Futbol", 9),
            new Deporte("Golf", 7)
    );

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public Integer getNivelByDeporte(String deporte) {
        return deportes.stream().filter(deporte1 ->
                deporte1.getNombre().toLowerCase()
                        .equals(deporte.toLowerCase())).findFirst().get().getNivel();
    }
}
