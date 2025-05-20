package com.mercadolibre.obrasliterarias.Controller;

import com.mercadolibre.obrasliterarias.domain.Libro;
import com.mercadolibre.obrasliterarias.service.ILibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("libro")
public class LibroController {
    private ILibroService libroService;

    public LibroController(ILibroService libroService) {
        this.libroService = libroService;
    }



    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<Libro>> getByNombre(@PathVariable String nombre){
        return new ResponseEntity<>(libroService.getByNombre(nombre), HttpStatus.OK);

    }

    @GetMapping("/obtener/{autor}")
    public ResponseEntity<List<Libro>> getByAutor(@PathVariable String autor){
        return new ResponseEntity<>(libroService.getByAutor(autor), HttpStatus.OK);
    }
    @GetMapping("/año/{year}")
    public ResponseEntity<List<Libro>> getByYear(@PathVariable Long year){
        return new ResponseEntity<>(libroService.getByYear(year), HttpStatus.OK);
    }
    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<Libro>> getByEditorial(@PathVariable String editorial){
        return new ResponseEntity<>(libroService.getByEditorial(editorial), HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Libro>> getTop(){
        return new ResponseEntity<>(libroService.getTopFive(), HttpStatus.OK);
    }

}
