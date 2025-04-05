package clases;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> guardaRopa;
    private Integer contador;

    public GuardaRopa() {
        this.guardaRopa = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador += 1;
        guardaRopa.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        for (Integer clave : guardaRopa.keySet()) {
            System.out.println("Clave: " + clave );
            System.out.println(guardaRopa.get(clave));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return guardaRopa.get(numero);
    }
}
