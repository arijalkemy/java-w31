package org.example.ejerciciopracticosextra1.service;

import org.example.ejerciciopracticosextra1.model.Prenda;
import org.example.ejerciciopracticosextra1.model.Venta;

import java.util.Date;
import java.util.List;

public interface IVentaService {
    List<Venta> getVentas();
    Venta getVentaByNumero(Long numero);
    List<Prenda> getPrendasByFecha(Date fecha);
    List<Prenda> getPrendasByNumero(Long numero);
    void createVenta(Venta venta);
    void updateVenta(Long numero, Venta venta);
    void deleteVenta(Long numero);
}
