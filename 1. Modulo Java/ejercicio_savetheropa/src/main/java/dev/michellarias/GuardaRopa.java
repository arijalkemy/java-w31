package dev.michellarias;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GuardaRopa {
    private Integer id;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.id = 0;
    }

    private Integer getId(){
        return id;
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        int nuevoId = getId() +  1;
        this.prendas.put(nuevoId, prendas);
        return nuevoId;
    }

    public void mostrarPrendas() {
        prendas.forEach((k, v) -> {
            System.out.println("#: " + k );
            v.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer id) {
        List<Prenda> prendas = this.prendas.get(id);
        if (Objects.isNull(prendas)) {
            throw new RuntimeException("Prenda no encontrada");
        }
        return prendas;
    }




}
