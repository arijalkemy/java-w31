import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/")
public class EdadController {

    private final PersonaService fechaService;


    public EdadController(PersonaService fechaService) {
        this.fechaService = fechaService;
    }
    @GetMapping("{dia}/{mes}/{anio}")
    public ResponseEntity<String> obtenerEdad(@RequestParam int dia, @RequestParam int mes, @RequestParam int anio) {
        try {
            FechaDeNacimiento fecha = new FechaDeNacimiento(dia, mes, anio);
            int edad = fechaService.calcularEdad(fecha);
            return ResponseEntity.ok("La edad es: " + edad);
        }catch (DateTimeException e){
            return ResponseEntity.badRequest().body("Fecha incorrecta");
        }
    }
}
