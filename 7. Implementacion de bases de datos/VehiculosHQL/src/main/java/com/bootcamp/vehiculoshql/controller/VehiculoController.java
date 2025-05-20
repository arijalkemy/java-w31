package com.bootcamp.vehiculoshql.controller;

import com.bootcamp.vehiculoshql.dto.VehiculoSiniestroDTO;
import com.bootcamp.vehiculoshql.service.VehiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/patentes")
    public List<String> getPatentes() {
        return vehiculoService.obtenerPatentes();
    }

    @GetMapping("/ordenados")
    public List<Object[]> getPatenteMarcaOrdenadosPorAnio() {
        return vehiculoService.listarPatenteMarcaOrdenadosPorAnio();
    }

    @GetMapping("/cuatro-ruedas/{anio}")
    public List<String> getVehiculosCuatroRuedas(@PathVariable int anio) {
        return vehiculoService.listarVehiculosMasDeCuatroRuedasAnoCorriente(anio);
    }

    // Listar vehículos con pérdida mayor a 10,000
    @GetMapping("/siniestro/mayor/{monto}")
    public List<VehiculoSiniestroDTO> getVehiculosConPerdidaMayor(@PathVariable double monto) {
        return vehiculoService.listarVehiculosConPerdidaMayor(monto);
    }

    // Listar vehículos con pérdida mayor a 10,000 y pérdida total
    @GetMapping("/siniestro/total/mayor/{monto}")
    public List<VehiculoSiniestroDTO> getVehiculosConPerdidaTotalMayor(@PathVariable double monto) {
        return vehiculoService.listarVehiculosConPerdidaTotalMayor(monto);
    }

}
