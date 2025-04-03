package com.mercadolibre.modulojava.savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> ropero=new HashMap<>();
    private Integer identificador=0;

    public GuardaRopa() {

    }
    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        identificador++;
        ropero.put(identificador, listaDePrenda);
        return identificador;

    }
    public void mostrarPrendas(){
        System.out.println(ropero);
    }
    public List<Prenda> devolverPrendas(Integer numero){
        return ropero.get(numero);
    }


}
