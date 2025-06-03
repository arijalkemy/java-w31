package com.meli.segurosautos.Controller;

import com.meli.segurosautos.Model.VehiculoSiniestro;
import com.meli.segurosautos.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/patentes")
    public List<String> listarPatentes(){
        return vehiculoService.listarPatentes();
    }

    @GetMapping("/patenteyMarcaPorAño")
    List<Object[]> listarPorAnioFabricacion() {
        return vehiculoService.listarPorAnioFabricacion();
    }

    @GetMapping("/especiales")
    public List<String> listarVehiculosEspeciales() {
        int aniooActual = LocalDate.now().getYear();
        return vehiculoService.listarVehiculosConMasDeCuatroRuedasYFabricacionReciente(aniooActual);
    }

    @GetMapping("/siniestros/mayorA/{cantidad}")
    public List<Object[]> listarVehiculosConSiniestroMayorA(@PathVariable double cantidad) {
        return vehiculoService.listarVehiculosConSiniestroMayorA(cantidad);
    }

    @GetMapping("/siniestros/mayorA/{cantidad}")
    public List<VehiculoSiniestro> listarVehiculosConPerdidaTotalMayorA(@PathVariable double cantidad) {
        return vehiculoService.listarVehiculosConPerdidaTotalMayorA(cantidad);
    }

}
