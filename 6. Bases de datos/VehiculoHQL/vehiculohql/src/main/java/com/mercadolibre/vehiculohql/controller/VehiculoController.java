package com.mercadolibre.vehiculohql.controller;

import com.mercadolibre.vehiculohql.dto.VehiculoConPerdidasDTO;
import com.mercadolibre.vehiculohql.dto.VehiculoPatenteMarcaDTO;
import com.mercadolibre.vehiculohql.dto.VehiculoPatenteMarcaModeloDTO;
import com.mercadolibre.vehiculohql.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;
    @GetMapping
    public ResponseEntity<List<String>> getPatentesDeTodosLosVehiculos(){
        return new ResponseEntity<>(vehiculoService.getPatentesDeTodosLosVehiculos(), HttpStatus.OK);
    }
    @GetMapping("/patente/order")
    public ResponseEntity<List<VehiculoPatenteMarcaDTO>> getPatenteYMarcaDeVehiculosOrdenadosPorAnioDeFabricacion(){
        return new ResponseEntity<>(vehiculoService.getPatenteYMarcaDeVehiculosOrdenadosPorAnioDeFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/patente/ruedas/4/anio/{anio}")
    public ResponseEntity<List<String>> getPatentesDeVehiculosConMasDeCuatroRuedasYAño(@PathVariable Integer anio){
        return new ResponseEntity<>(vehiculoService.getPatentesDeVehiculosConMasDeCuatroRuedasYAño(anio), HttpStatus.OK);
    }

    @GetMapping("/patente/siniestros/10k")
    public ResponseEntity<List<VehiculoPatenteMarcaModeloDTO>> getVehiculosConSiniestrosMayoresA10k(){
        return new ResponseEntity<>(vehiculoService.getVehiculosConSiniestrosMayoresA10k(), HttpStatus.OK);
    }

    @GetMapping("/patente/siniestros/10k/perdidas")
    public ResponseEntity<List<VehiculoConPerdidasDTO>> getVehiculosConSiniestrosMayoresA10kYPerdidaTotal(){
        return new ResponseEntity<>(vehiculoService.getVehiculosConSiniestrosMayoresA10kYPerdidaTotal(), HttpStatus.OK);
    }

}
