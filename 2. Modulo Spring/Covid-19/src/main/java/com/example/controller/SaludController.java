import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class SaludController {

    private List<Sintoma> listaSintomas = new ArrayList<>();
    private List<Persona> listaPersonas = new ArrayList<>();

    public SaludController() {
        listaSintomas.add(new Sintoma("S1", "Fiebre", "Alta"));
        listaSintomas.add(new Sintoma("S2", "Tos", "Media"));
        listaSintomas.add(new Sintoma("S3", "Dolor de cabeza", "Baja"));

        listaPersonas.add(new Persona(1, "Ana", "Pérez", 65, List.of(listaSintomas.get(0))));
        listaPersonas.add(new Persona(2, "Luis", "Gómez", 45, List.of()));
        listaPersonas.add(new Persona(3, "María", "López", 70, List.of(listaSintomas.get(1), listaSintomas.get(2))));
    }

    @GetMapping("/findSymptom")
    public List<Sintoma> obtenerTodosLosSintomas() {
        return listaSintomas;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> buscarSintoma(@PathVariable String name) {
        for (Sintoma s : listaSintomas) {
            if (s.getNombre().equalsIgnoreCase(name)) {
                return ResponseEntity.ok("Nivel de gravedad: " + s.getNivelDeGravedad());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Síntoma no encontrado");
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaRiesgoDTO> obtenerPersonasDeRiesgo() {
        List<PersonaRiesgoDTO> personasRiesgo = new ArrayList<>();

        for (Persona p : listaPersonas) {
            if (p.getEdad() > 60 && !p.getSintomas().isEmpty()) {
                personasRiesgo.add(new PersonaRiesgoDTO(p.getNombre(), p.getApellido()));
            }
        }

        return personasRiesgo;
    }
}
