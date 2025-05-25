package com.mercadolibre.empresaseguroshql.controller;

import com.mercadolibre.empresaseguroshql.dto.PatenteMarcaDTO;
import com.mercadolibre.empresaseguroshql.dto.VehiculoInfoDTO;
import com.mercadolibre.empresaseguroshql.dto.VehiculoSiniestroDTO;
import com.mercadolibre.empresaseguroshql.model.Vehiculo;
import com.mercadolibre.empresaseguroshql.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    //Listar patentes de todos los vehiculos registrados
    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getPatentes() {
        return new ResponseEntity<>(vehiculoService.listarPatentes(), HttpStatus.OK);
    }

    //Listar patentes y Marca de todos los vehiculos ordenador por anio de fabricacion
    @GetMapping("/patente-marca")
    public ResponseEntity<List<Object[]>> getPatenteYMarca() {
        return new ResponseEntity<>(vehiculoService.getPatenteYMarca(), HttpStatus.OK);
    }

    //Listar patente de todos los vehiculo que tengan mas de 4 ruedas
    //y hayan sido fabricados en el corriente Anio
    @GetMapping("/patentes-ruedas-anio")
    public ResponseEntity<List<String>> getPatentesRuedasAnio() {
        return new ResponseEntity<>(vehiculoService.listarPatentesRuedasYAnio(), HttpStatus.OK);
    }

    //Listar la matricula, marca y modelo de todos los vehiculos que hayan tenido un siniestro con perdida
    //mayor de 10000 pesos
    @GetMapping("/siniestro-mayor-10000")
    public ResponseEntity<List<VehiculoInfoDTO>> getVehiculosConSiniestroMayorA10000() {
        return new ResponseEntity<>(vehiculoService.listarVehiculosConSiniestroMayorA10000(), HttpStatus.OK);
    }

    //Listar Matricula marca y modelo de todos los vehiculos que hayan tenido un siniestro
    //con perdida mayor de 10000 pesos y mostrar cuanto ascendio la perdida total
    // de todos ellos
//    @GetMapping("/siniestro-mayor-10000-perdida-total")
//    public ResponseEntity<List<VehiculoSiniestroDTO>> getVehiculosConSiniestroMayorA10000YPerdidaTotal() {
//        return new ResponseEntity<>(vehiculoService.listarVehiculosConSiniestroMayorA10000YPerdidaTotal(), HttpStatus.OK);
//    }
}