package com.meli.segurosautos.Service;

import com.meli.segurosautos.Model.VehiculoSiniestro;

import java.util.List;

public interface VehiculoService {
    List<String> listarPatentes();
    List<Object[]> listarPorAnioFabricacion();
    List<String> listarVehiculosConMasDeCuatroRuedasYFabricacionReciente(int añoActual);
    List<Object[]> listarVehiculosConSiniestroMayorA(double cantidad);
    List<VehiculoSiniestro> listarVehiculosConPerdidaTotalMayorA(double cantidad);
}
