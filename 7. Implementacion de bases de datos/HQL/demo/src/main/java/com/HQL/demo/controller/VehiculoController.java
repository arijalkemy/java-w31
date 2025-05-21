package com.HQL.demo.controller;

import com.HQL.demo.dto.VehiculoSiniestroDTO;
import com.HQL.demo.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/patentes")
    public List<String> getPatentes() {
        return vehiculoService.listarPatentes();
    }

    @GetMapping("/patente-marca")
    public List<Object[]> getPatenteMarca() {
        return vehiculoService.listarPatenteMarcaPorAnio();
    }

    @GetMapping("/patentes-grandes/{anio}")
    public List<String> getPatentesGrandes(@PathVariable Integer anio) {
        return vehiculoService.listarPatentesRuedasYAnio(anio);
    }

    @GetMapping("/siniestros-mayor-perdida")
    public List<Object[]> getMatriculaMarcaModeloConPerdidaGrande() {
        return vehiculoService.listarMatriculaMarcaModeloConPerdidaGrande();
    }

    @GetMapping("/siniestros-mayor-perdida-total")
    public List<VehiculoSiniestroDTO> getVehiculosConPerdidaTotal() {
        return vehiculoService.listarVehiculosPerdidaTotal();
    }
}
