package EJINT_SaveTheRopa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    //guardar ropa
    public int guardarRopa(Prenda prenda) {
        this.contador++;
        //si no existe lista crearla
        prendas.putIfAbsent(contador, new ArrayList<>());
        prendas.get(contador).add(prenda);
        return contador;
    }

    //lista de prendas segun id
    public List<Prenda> obtenerPrendas(int id) {
        return this.prendas.getOrDefault(id, new ArrayList<>());
    }

    //devolver una prenda segun su id
    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.getOrDefault(numero, new ArrayList<>());
    }

    //ver prendas
    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : this.prendas.entrySet()) {
            System.out.println("ID: "+ entry.getKey() +  " => Prendas: " + entry.getValue().size());
        }
    }


}
