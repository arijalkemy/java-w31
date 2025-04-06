package org.meli.savethereposa.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> mapaDePrendas;

    public GuardaRopa() {
        mapaDePrendas = new HashMap<>();
    }

    public GuardaRopa(Map<Integer, List<Prenda>> mapaDePrendas) {
        this.mapaDePrendas = mapaDePrendas;
    }

    public Map<Integer, List<Prenda>> getMapaDePrendas() {
        return mapaDePrendas;
    }

    public void setMapaDePrendas(Map<Integer, List<Prenda>> mapaDePrendas) {
        this.mapaDePrendas = mapaDePrendas;
    }


}
