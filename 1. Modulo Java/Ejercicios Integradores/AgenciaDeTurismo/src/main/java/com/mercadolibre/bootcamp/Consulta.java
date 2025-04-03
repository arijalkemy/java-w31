package com.mercadolibre.bootcamp;

import com.mercadolibre.bootcamp.model.Cliente;
import com.mercadolibre.bootcamp.model.Producto;
import com.mercadolibre.bootcamp.model.TipoProducto;
import com.mercadolibre.bootcamp.repository.RepositorioCliente;
import com.mercadolibre.bootcamp.repository.RepositorioLocalizador;

import java.util.List;
import java.util.Map;

public class Consulta {

    private RepositorioCliente repositorioCliente;
    private RepositorioLocalizador repositorioLocalizador;

    public Consulta(RepositorioCliente repositorioCliente, RepositorioLocalizador repositorioLocalizador) {
        this.repositorioCliente = repositorioCliente;
        this.repositorioLocalizador = repositorioLocalizador;
    }

    public Integer cantidadLocalizadoresVendidos() {
        return repositorioLocalizador.getAllLocalizadores().size();
    }

    public Integer totalProductosVendidos() {
        return repositorioLocalizador.totalProductosVendidos();
    }

    public Map<TipoProducto, List<Producto>> getProductosVendidosPorTipo(){
        return repositorioLocalizador.getProductosPorTipo();
    }

    public Double totalVentas(){
        return repositorioLocalizador.totalVentas();
    }

    public Double promedioVentas(){
        return repositorioLocalizador.promedioVentas();
    }





}
