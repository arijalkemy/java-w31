package org.meli.agenciadeturismo.repository;

import org.meli.agenciadeturismo.domain.Cliente;
import org.meli.agenciadeturismo.domain.Localizador;

import java.util.List;

public interface ClienteRepository <T extends Cliente>{

    double aplicarDescuento (Cliente cliente);

}
