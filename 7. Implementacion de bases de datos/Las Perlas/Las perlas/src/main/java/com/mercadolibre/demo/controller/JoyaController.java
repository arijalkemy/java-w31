package com.mercadolibre.demo.controller;

import com.mercadolibre.demo.dto.JoyaDTO;
import com.mercadolibre.demo.service.IJoyaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private final IJoyaService service;

    public JoyaController(IJoyaService service) {
        this.service = service;
    }

     /*Crear una nueva joya y devolver el correspondiente status code con un mensaje
    informando su “nro identificatorio”. (URI: /jewerly/new).
     */

    @PostMapping("/new")
    public ResponseEntity<Long> newJewerly(@RequestBody JoyaDTO joya) {
        return ResponseEntity.ok(service.newJewerly(joya));
    }

    /*Devolver el listado de todas las joyas registradas. (URI: /jewerly).*/

    @GetMapping("")
    public ResponseEntity<List<JoyaDTO>> getAllJewerly (){
        return ResponseEntity.ok(service.getAllJewerly());
    }

      /*Eliminar “lógicamente” una joya. Para ello, se deberá contemplar un campo que
    se llama “ventaONo”, el cual debe ser verdadero al crear una nueva joya, y falso
    cuando se solicite el eliminado. En caso de estar eliminado lógicamente,
    no deberá ser devuelto en el listado de joyas registradas. (URI: /jewerly/delete/{id})*/

    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJewerly(@PathVariable Long id){
        service.deleteJewerly(id);
        return ResponseEntity.noContent().build();
    }

      /*Actualizar los datos de una joya. Una vez actualizados, devolver un mensaje
    con el correspondiente status code y los datos de la joya modificada.
     (URI: /jewerly/update/{id_modificar}).
      Envía el objeto completo para editar (sin cambiar la id).*/

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaDTO> updateJewerly(@PathVariable("id_modificar") Long id, @RequestBody JoyaDTO joya){
        return ResponseEntity.ok(service.updateJewerly(id, joya));
    }

}