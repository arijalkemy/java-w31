package com.mercadolibre.bootcamp.repository;

import com.mercadolibre.bootcamp.model.Cliente;
import com.mercadolibre.bootcamp.model.Localizador;
import com.mercadolibre.bootcamp.model.Producto;
import com.mercadolibre.bootcamp.model.TipoProducto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioLocalizador {

    Map<Long, Localizador> localizadores;

    public RepositorioLocalizador() {
        this.localizadores = new HashMap<>();
    }

    public Localizador agregarLocalizador(Localizador localizador) {
        return localizadores.put(localizador.getId(), localizador);
    }

    public List<Localizador> getAllLocalizadores() {
        return new ArrayList<>(localizadores.values());
    }

    public Localizador getLocalizador(Long id) {
        return localizadores.get(id);
    }

    public Localizador getByCliente(Cliente cliente) {
        return localizadores.values().stream().filter(localizador -> localizador.getCliente().equals(cliente)).findFirst().orElse(null);
    }

    public Integer totalProductosVendidos() {
        return localizadores.values().stream().mapToInt(l -> l.getProductos().size()).sum();
    }

    public Map<TipoProducto, List<Producto>> getProductosPorTipo(){
        Map<TipoProducto, List<Producto>> map = new HashMap<>();
        for(TipoProducto tipo: TipoProducto.values()) {
            List<Producto> productos = localizadores.values().stream().flatMap(l -> l.getProductos()
                    .stream().filter(p -> p.getTipo().equals(tipo))).collect(Collectors.toList());
            map.put(tipo, productos );
        }
        return  map;
    }

    public Double totalVentas(){
        return localizadores.values().stream().flatMap(l -> l.getProductos().stream()).mapToDouble( p -> p.getPrecio()).sum();
    }

    public Double promedioVentas(){
        return localizadores.values().stream().flatMap(l -> l.getProductos().stream()).mapToDouble( p -> p.getPrecio()).average().getAsDouble();
    }


}
