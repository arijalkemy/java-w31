package ejercicio_guardaropa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> ropero;
    private Integer contador;

    public GuardaRopa() {
        this.ropero = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        this.contador++;
        this.ropero.put(this.contador, listaDePrendas);
        return this.contador;
    }

    public void mostrarPrendas() {
        System.out.println(ropero);
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.ropero.get(numero);
    }
}
